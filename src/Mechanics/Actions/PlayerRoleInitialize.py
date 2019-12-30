from src.Concepts.Role import Role
from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate
from typing import FrozenSet

class PlayerRoleInitialize(GamestateAction):
    """ The Player Role Initialize action set the possible roles of a player from None to a given set of roles. """

    def __init__(self, player_id: int, roles: FrozenSet[Role]):
        """ Constructor of the Player Role Initialize action.

        Arguments:
            player_id (int): The id of the player which roles get initialized.
            roles (FrozenSet[Role]): The roles which the player can get.
        """
        self.player_id = player_id
        self.roles = roles

    def do(self, state: Gamestate):
        state.playerRoles[self.player_id] = self.roles

    def undo(self, state: Gamestate):
        state.playerRoles[self.player_id] = None