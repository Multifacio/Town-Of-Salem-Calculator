from __future__ import annotations
from collections import Set
from src.Conditions.Condition import Condition
from src.Concepts.Rolegroup import Rolegroup as RG
from typing import List, TYPE_CHECKING
if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate
    from src.Concepts.Role import Role

class PlayerIsRoleCondition(Condition):
    """ The Player Is Role Condition means that a player should have a role in a given set of roles. """

    def __init__(self, player_id: int, roles: Set[Role]):
        """ Constructor of the Player Is Role Condition.

        Arguments:
            player_id (int): The id of the player of which its role is in the given set of roles.
            roles (Set[Role]): The set of roles of which one role is the role of the given player.
        """
        self.player_id = player_id
        self.roles = roles

    def valid_skip(self, state: Gamestate):
        pr = state.playerRoles[self.player_id]
        if pr is None:
            for cr in state.categoryRoles:
                if not cr.issubset(self.roles):
                    return False
            return True
        else:
            return pr.issubset(self.roles)

    def inner_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        pr = state.playerRoles[self.player_id]
        if pr is None:
            return self.__category_fill_evidence(state)
        else:
            return self.__player_fill_evidence(state)

    def opposite(self) -> Condition:
        opposite_roles = RG.NC_ALL.difference(self.roles)
        return PlayerIsRoleCondition(self.player_id, opposite_roles)

    def __category_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        """ Fill in the possible roles of the player if there is no information about the role of the player. Hence we
        will select a category that should belong to this player. """

        category_options = dict()
        for i, cr in enumerate(state.categoryRoles):
            if not cr.isdisjoint(self.roles):
                cr = frozenset(cr)
                if cr in category_options:
                    co = category_options[cr]
                    category_options[cr] = (co[0], co[1] + 1)
                else:
                    category_options[cr] = (i, 1)

        new_states = []
        for cr, occ in category_options.items():
            i, multiplier = occ
            new_state = state.copy()
            new_roles = cr.intersection(self.roles)
            del new_state.categoryRoles[i]
            new_state.playerRoles[self.player_id] = new_roles
            new_state.multiplier *= multiplier
            new_states.append(new_state)
        return new_states

    def __player_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        """ Fill in the possible roles of the player if there is already information about the role of that player. """
        new_state = state.copy()
        new_roles = new_state.playerRoles[self.player_id].intersection(self.roles)
        if new_roles:
            return [new_state]
        else:
            return []