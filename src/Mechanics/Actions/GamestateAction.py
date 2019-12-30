from src.Mechanics.Gamestate import Gamestate

class GamestateAction:
    """ A Gamestate Action is an action on a Gamestate which changes the variables of that given Gamestate. """

    def do(self, state: Gamestate):
        """ Execute the action on a given Gamestate.

        Arguments:
            state (Gamestate): The Gamestate on which the action is executed.
        """
        pass

    def undo(self, state: Gamestate):
        """ Undo the action (do the reverse of this action).

        Arguments:
            state (Gamestate): The Gamestate on which the action will be undone.
        """
        pass