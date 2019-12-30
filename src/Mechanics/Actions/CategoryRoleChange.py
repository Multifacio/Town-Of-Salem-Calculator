from src.Concepts.Role import Role
from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate
from typing import FrozenSet

class CategoryRoleChange(GamestateAction):
    """ The Category Role Change action changes the occurrence of a given category role. """

    def __init__(self, roles: FrozenSet[Role], amount: int):
        """ Constructor of the Category Role Change action.

        Arguments:
            roles (FrozenSet[Role]): The category role of which the occurrence is changed.
            amount (int): The relative amount by which the occurrence is changed.
        """
        self.roles = roles
        self.amount = amount

    def do(self, state: Gamestate):
        new_occurrence = state.categoryRoles.get(self.roles, 0) + self.amount
        if new_occurrence <= 0:
            del state.categoryRoles[self.roles]
        else:
            state.categoryRoles[self.roles] = new_occurrence

    def undo(self, state: Gamestate):
        state.categoryRoles[self.roles] = state.categoryRoles.get(self.roles, 0) - self.amount