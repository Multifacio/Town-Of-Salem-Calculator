from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate

class RemoveFirstCondition(GamestateAction):
    """ The Remove First Condition action removes the first condition from the list of conditions of the Gamestate. """

    def do(self, state: Gamestate):
        self.removed_condition = state.conditions[0]
        del state.conditions[0]

    def undo(self, state: Gamestate):
        state.conditions.insert(0, self.removed_condition)