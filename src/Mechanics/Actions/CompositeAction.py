from src.Mechanics.Actions.GamestateAction import GamestateAction
from src.Mechanics.Gamestate import Gamestate
from typing import List

class CompositeAction(GamestateAction):
    """ The Composite Action contains multiple actions and upon execution it will execute all included actions. """

    def __init__(self, actions: List[GamestateAction]):
        """ Constructor of the Composite Action.

        Arguments:
            actions (List[GamestateAction]): The list of actions that get executed when executing this action.
        """
        self.actions = actions

    def do(self, state: Gamestate):
        for action in self.actions:
            action.do(state)

    def undo(self, state: Gamestate):
        for action in reversed(self.actions):
            action.undo(state)