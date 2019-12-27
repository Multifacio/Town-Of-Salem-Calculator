from __future__ import annotations
from src.Mechanics.Gamestate import Gamestate
from typing import List

class Condition:
    """ A statement about the current Gamesituation which can either hold or not. """

    def fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        """ Fill in the evidence by giving a partitioning (list of disjoint game states which unified cover all
        possible states) where all the partitioned Gamestate all satisfy this condition.

        Arguments:
            state (Gamestate): The current Gamestate on which we fill in this condition as evidence.

        Returns:
            A list of Gamestates which together form a partitioning for all possible Gamestates in which this condition
            holds. Returns an empty list when the condition cannot be satisfied anymore.
        """
        pass

    def opposite(self) -> Condition:
        """ Get the opposite condition (condition that is satisfied when this condition is falsified and vice-versa).

        Returns:
            The opposite condition of this condition.
        """
        pass