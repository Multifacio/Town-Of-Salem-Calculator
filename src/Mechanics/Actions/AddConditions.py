from src.Conditions.Condition import Condition
from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate
from typing import List

class AddConditions(GamestateAction):
    """ The Add Conditions action will add a list of conditions to the Gamestate upon execution of this action. """

    def __init__(self, conditions: List[Condition]):
        """ Constructor of the Add Conditions action.

        Arguments:
            conditions (List[Condition]): The list of conditions that should be added to the Gamestate.
        """
        self.conditions = conditions

    def do(self, state: Gamestate):
        state.conditions = self.conditions + state.conditions

    def undo(self, state: Gamestate):
        del state.conditions[:len(self.conditions)]