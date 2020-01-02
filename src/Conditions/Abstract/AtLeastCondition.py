from __future__ import annotations
from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Condition import Condition
from typing import List, TYPE_CHECKING, Union, NamedTuple, FrozenSet, Tuple
import math
if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate
    from src.Concepts.Role import Role

AtLeastSelector = NamedTuple("AtLeastSelector", [("isPlayerRole", bool), ("index", Union[FrozenSet[Role], int]),
                                                 ("multiplier", int)])
class AtLeastCondition(Condition):
    """ The At Least Condition means that a set of roles should occur at least a given amount of times (n) between the
    players which means that n players should have one of the roles in this set of roles. """

    def __init__(self, roles: FrozenSet[Role], amount: int):
        """ Constructor of the At Least Condition.

        Arguments:
            roles (FrozenSet[Role]): The set of roles which should occur at least a given amount of times.
            amount (int): How often these roles should occur at least.
        """
        self.roles = roles
        self.amount = amount

    def valid_skip(self, state: Gamestate):
        return self.__valid_count(state) >= self.amount

    def inner_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        # Check which category and game roles can be filled in with this condition.
        if self.valid_skip(state):
            return [state.copy()]

        options = []
        options_sum = 0
        for cr, num in state.categoryRoles.items():
            if not self.roles.isdisjoint(cr):
                options.append(AtLeastSelector(False, cr, num))
                options_sum += num

        for i, pr in state.playerRoles.items():
            if pr is not None and not self.roles.isdisjoint(pr):
                options.append(AtLeastSelector(True, i, 1))
                options_sum += 1

        opposite_roles = RG.NC_ALL.difference(self.roles)
        result = []
        self.__all_combination(state, options, opposite_roles, (), 0, options_sum, len(options), result)
        return result

    def opposite(self) -> Condition:
        from src.Conditions.Abstract.AtMostCondition import AtMostCondition
        return AtMostCondition(self.roles, self.amount - 1)

    def priority(self) -> float:
        return 40.0 + 1.0 / ((len(RG.NC_ALL.difference(self.roles)) ** 2 + 1) * (self.amount + 1))

    def __all_combination(self, state: Gamestate, options: List[AtLeastSelector], opposite_roles: FrozenSet[Role],
                        cur_comb: Tuple[int, ...], index: int, options_sum: int, option_size: int, result: List[Gamestate]):
        """ Determine all possible combinations for the given list of options (contains all possible category and player
        roles that can be filled in). """
        if options_sum >= self.amount:
            if index == option_size:
                if self.__valid__combination(state, options, opposite_roles, cur_comb):
                    new_state = self.__state_combination(state, options, opposite_roles, cur_comb)
                    result.append(new_state)
            else:
                max = options[index].multiplier
                for i in range(max + 1):
                    self.__all_combination(state, options, opposite_roles, cur_comb + (i,), index + 1,
                                           options_sum + i - max, option_size, result)

    def __valid__combination(self, state: Gamestate, options: List[AtLeastSelector], opposite_roles: FrozenSet[Role],
                            combination: Tuple[int, ...]) -> bool:
        """ Check if the corresponding state for a given combination is valid where the combination indicates which
        options should be selected. """
        for num, option in zip(combination, options):
            if option.isPlayerRole:
                i = option.index
                if state.playerRoles[i].isdisjoint(self.roles if num == 1 else opposite_roles):
                    return False
            else:
                _, cr, max = option
                if num > 0 and cr.isdisjoint(self.roles):
                    return False

                num = max - num
                if num > 0 and cr.isdisjoint(opposite_roles):
                    return False

        return True

    def __state_combination(self, state: Gamestate, options: List[AtLeastSelector], opposite_roles: FrozenSet[Role],
                            combination: Tuple[int, ...]) -> Gamestate:
        """ Compute the corresponding state for a given combination where the combination indicates which options
        should be selected. Returns None if the combination is not valid. """
        new_state = state.copy()
        for num, option in zip(combination, options):
            new_state.multiplier *= self.__nCr(option.multiplier, num)
            if option.isPlayerRole:
                i = option.index
                new_state.playerRoles[i] = new_state.playerRoles[i].intersection(self.roles if num == 1 else opposite_roles)
            else:
                _, cr, max = option
                new_occ = new_state.categoryRoles[cr] - max
                if new_occ == 0:
                    del new_state.categoryRoles[cr]
                else:
                    new_state.categoryRoles[cr] = new_occ

                if num > 0:
                    nr = cr.intersection(self.roles)
                    new_state.categoryRoles[nr] = new_state.categoryRoles.get(nr, 0) + num

                num = max - num
                if num > 0:
                    nor = cr.intersection(opposite_roles)
                    new_state.categoryRoles[nor] = new_state.categoryRoles.get(nor, 0) + num

        return new_state

    def __valid_count(self, state: Gamestate) -> int:
        """ Compute how many players and categories will always satisfy this condition (are valid). """
        valid_count = 0
        for cr, num in state.categoryRoles.items():
            if cr.issubset(self.roles):
                valid_count += num

        for pr in state.playerRoles.values():
            if pr is not None and pr.issubset(self.roles):
                valid_count += 1

        return valid_count

    @staticmethod
    def __nCr(n: int, k: int) -> int:
        return math.factorial(n) // math.factorial(k) // math.factorial(n - k)