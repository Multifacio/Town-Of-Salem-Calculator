from __future__ import annotations
from typing import List, TYPE_CHECKING
if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate

class Condition:
    """ A statement about the current Gamesituation which can either hold or not. """

    def valid_skip(self, state: Gamestate) -> bool:
        """ The valid skip function quickly checks if a condition is always satisfied for a given Gamestate (if so it
        will skip the evidence filling).

        Arguments:
            state (Gamestate): The current Gamestate for which we quickly want to check if it is valid.

        Returns:
            True if the condition is definitely valid (always satisfied), false if the condition might be falsifiable
            (however in case it returns False it might still be a valid condition).
        """
        pass

    def fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        """ Fill in the evidence by giving a partitioning (list of disjoint game states which unified cover all possible
        states) where all the partitioned Gamestates satisfy this condition. Do not override this function, but override
        innner_fill_evidence instead when creating new conditions.

        Arguments:
            state (Gamestate): The current Gamestate on which we fill in this condition as evidence.

        Returns:
            A list of Gamestates which together form a partitioning for all possible Gamestates in which this condition
            holds. Returns an empty list when the condition cannot be satisfied anymore.
        """
        if self.valid_skip(state):
            return [state.copy()]
        elif self.opposite().valid_skip(state):
            return []
        else:
            return self.inner_fill_evidence(state)

    def inner_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        pass

    def opposite(self) -> Condition:
        """ Get the opposite condition (condition that is satisfied when this condition is falsified and vice-versa).

        Returns:
            The opposite condition of this condition.
        """
        pass