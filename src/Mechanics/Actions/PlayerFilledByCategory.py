from src.Concepts.Role import Role
from src.Mechanics.Actions.CategoryRoleChange import CategoryRoleChange
from src.Mechanics.Actions.CompositeAction import CompositeAction
from src.Mechanics.Actions.MultiplierChange import MultiplierChange
from src.Mechanics.Actions.PlayerRoleInitialize import PlayerRoleInitialize
from src.Mechanics.Gamestate import Gamestate
from typing import FrozenSet

class PlayerFilledByCategory(CompositeAction):
    """ The Player Filled By Category action gives a given player a given set of roles using a given category role. """

    def __init__(self, player_id: int, player_roles: FrozenSet[Role], category_roles: FrozenSet[Role], category_amount: int):
        self.new_player_roles = category_roles.intersection(player_roles)
        super().__init__([CategoryRoleChange(category_roles, -1), PlayerRoleInitialize(player_id, self.new_player_roles),
                          MultiplierChange(category_amount)])

    def valid(self) -> bool:
        """ Check if this action is valid.

        Returns:
            True if this action is valid (can be executed) and false otherwise.
        """
        return bool(self.new_player_roles)