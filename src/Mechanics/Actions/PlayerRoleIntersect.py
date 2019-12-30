from src.Concepts.Role import Role
from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate
from typing import FrozenSet

class PlayerRoleIntersect(GamestateAction):
    """ The Player Role Intersect action intersects the possible roles of a player with a given set of roles. """

    def __init__(self, player_id: int, intersect_roles: FrozenSet[Role]):
        """ Constructor of the Player Role Intersect action.

        Arguments:
            player_id (int): The id of the player which roles get intersected.
            intersect_roles (FrozenSet[Role]): The roles which gets intersected to the roles of that player
        """
        self.player_id = player_id
        self.intersect_roles = intersect_roles

    def do(self, state: Gamestate):
        self.old_roles = state.playerRoles[self.player_id]
        state.playerRoles[self.player_id] = self.old_roles.intersection(self.intersect_roles)

    def undo(self, state: Gamestate):
        state.playerRoles[self.player_id] = self.old_roles

    def valid(self, state: Gamestate) -> bool:
        """ Check if this action is valid.

        Arguments:
            state (Gamestate): The Gamestate on which the action is executed.

        Returns:
            True if this action is valid (can be executed) and false otherwise.
        """
        return not self.intersect_roles.isdisjoint(state.playerRoles[self.player_id])