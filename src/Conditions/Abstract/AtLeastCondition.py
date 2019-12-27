from __future__ import annotations
from src.Conditions.Condition import Condition
from src.Concepts.Rolegroup import Rolegroup as RG
from typing import Set, List, Tuple, TYPE_CHECKING
import itertools as it
if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate
    from src.Concepts.Role import Role

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

    def fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        # If the condition is valid (always satisfied) then just remove this condition from the state and return a list
        # with only this state as element.
        if self.__valid_count(state) >= self.amount:
            return [state.copy()]

        # Check which category and game roles can be filled in with this condition.
        options = []
        for i, cr in enumerate(state.categoryRoles):
            if not self.roles.isdisjoint(cr):
                options.append((False, i))
        for i, pr in state.playerRoles.items():
            if pr is not None and not self.roles.isdisjoint(pr):
                options.append((True, i))

        # Check if this condition is unsatisfiable and if so return an empty list
        if len(options) < self.amount:
            return []

        # Loop through all possible new states
        new_states = []
        opposite_roles = RG.NC_ALL.difference(self.roles)
        for num in range(self.amount, len(options) + 1):
            for comb in it.combinations(range(len(options)), num):
                new_states.append(self.__state_permutation(state, options, set(comb), opposite_roles))

        return new_states

    def opposite(self) -> Condition:
        from src.Conditions.Abstract.AtMostCondition import AtMostCondition
        return AtMostCondition(self.roles, self.amount - 1)

    def __state_permutation(self, state: Gamestate, options: List[Tuple[bool, int]], combination: Set[int],
                            opposite_roles: Set[Role]) -> Gamestate:
        """ Compute the corresponding state for a given permutation where the permutation are all the indices in the
        option list that should be a subset of the set of roles given for this condition. """
        new_state = state.copy()
        for i, option in enumerate(options):
            intersect_roles = self.roles if i in combination else opposite_roles
            is_player_role, index = option
            if is_player_role:
                new_state.playerRoles[i].intersection_update(intersect_roles)
            else:
                new_state.categoryRoles[i].intersection_update(intersect_roles)

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