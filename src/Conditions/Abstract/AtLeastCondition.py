from __future__ import annotations

import math

from src.Conditions.Condition import Condition
from src.Concepts.Rolegroup import Rolegroup as RG
from typing import Set, List, Tuple, TYPE_CHECKING, Union, NamedTuple
import itertools as it
if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate
    from src.Concepts.Role import Role

AtLeastSelector = NamedTuple("AtLeastSelector", [("isPlayerRole", bool), ("index", Union[List[int], int]),
                                                 ("multiplier", int)])
class AtLeastCondition(Condition):
    """ The At Least Condition means that a set of roles should occur at least a given amount of times (n) between the
    players which means that n players should have one of the roles in this set of roles. """

    def __init__(self, roles: Set[Role], amount: int):
        """ Constructor of the At Least Condition.

        Arguments:
            roles (Set[Role]): The set of roles which should occur at least a given amount of times.
            amount (int): How often these roles should occur at least.
        """
        self.roles = roles
        self.amount = amount

    def valid_skip(self, state: Gamestate):
        return self.__valid_count(state) >= self.amount

    def inner_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        # Check which category can be filled in with this condition
        category_options = dict()
        for i, cr in enumerate(state.categoryRoles):
            cr = frozenset(cr)
            if not self.roles.isdisjoint(cr):
                if cr in category_options:
                    co = category_options[cr]
                    category_options[cr] = AtLeastSelector(False, co.index + [i], co.multiplier + 1)
                else:
                    category_options[cr] = AtLeastSelector(False, [i], 1)

        # Check which game roles can be filled in with this condition.
        options = list(category_options.values())
        for i, pr in state.playerRoles.items():
            if pr is not None and not self.roles.isdisjoint(pr):
                options.append(AtLeastSelector(True, i, 1))

        opposite_roles = RG.NC_ALL.difference(self.roles)
        return self.__all_combination(state, options, opposite_roles, [])

    def opposite(self) -> Condition:
        from src.Conditions.Abstract.AtMostCondition import AtMostCondition
        return AtMostCondition(self.roles, self.amount - 1)

    def __all_combination(self, state: Gamestate, options: List[AtLeastSelector], opposite_roles: Set[Role],
                          cur_comb: List[int]) -> List[Gamestate]:
        """ Determine all possible combinations for the given list of options (contains all possible category and player
        roles that can be filled in). """
        index = len(cur_comb)
        optimistic_comb = cur_comb + [options[i].multiplier for i in range(index, len(options))]
        optimistic_count = sum(optimistic_comb)
        if optimistic_count < self.amount:
            return []
        else:
            if index == len(options):
                new_state = self.__state_combination(state, options, opposite_roles, cur_comb)
                if new_state is None:
                    return []
                else:
                    return [new_state]
            else:
                new_states = []
                for i in range(options[index].multiplier + 1):
                    new_states += self.__all_combination(state, options, opposite_roles, cur_comb + [i])
                return new_states

    def __state_combination(self, state: Gamestate, options: List[AtLeastSelector], opposite_roles: Set[Role],
                            combination: List[int]) -> Union[Gamestate, None]:
        """ Compute the corresponding state for a given combination where the combination indicates which options
        should be selected. Returns None if the combination is not valid. """
        new_state = state.copy()
        multiplier = 1
        for num, option in zip(combination, options):
            multiplier *= self.__nCr(option.multiplier, num)
            if option.isPlayerRole:
                i = option.index
                new_roles = new_state.playerRoles[i].intersection(self.roles if num == 1 else opposite_roles)
                if new_roles:
                    new_state.playerRoles[i] = new_roles
                else:
                    return None
            else:
                for i in option.index[:num]:
                    new_roles = new_state.categoryRoles[i].intersection(self.roles)
                    if new_roles:
                        new_state.categoryRoles[i] = new_roles
                    else:
                        return None
                for i in option.index[num:]:
                    new_roles = new_state.categoryRoles[i].intersection(opposite_roles)
                    if new_roles:
                        new_state.categoryRoles[i] = new_roles
                    else:
                        return None
        new_state.multiplier *= multiplier
        return new_state

    def __valid_count(self, state: Gamestate) -> int:
        """ Compute how many players and categories will always satisfy this condition (are valid). """
        valid_count = 0
        for cr in state.categoryRoles:
            if cr.issubset(self.roles):
                valid_count += 1

        for pr in state.playerRoles.values():
            if pr is not None and pr.issubset(self.roles):
                valid_count += 1

        return valid_count

    @staticmethod
    def __nCr(n: int, k: int) -> int:
        return math.factorial(n) // math.factorial(k) // math.factorial(n - k)