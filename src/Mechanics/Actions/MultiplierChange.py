from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate

class MultiplierChange(GamestateAction):
    """ The Multiplier Change action will multiply the multiplier of the Gamestate by a given value. """

    def __init__(self, multiply: int):
        """ Constructor of the Multiplier Change action.

        Arguments:
            multiply (int): The multiplier gets multiplied by this value.
        """
        self.multiply = multiply

    def do(self, state: Gamestate):
        state.multiplier *= self.multiply

    def undo(self, state: Gamestate):
        state.multiplier /= self.multiply