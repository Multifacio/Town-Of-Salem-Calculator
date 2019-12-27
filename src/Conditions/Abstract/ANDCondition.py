from typing import List
from src.Mechanics.Gamestate import Gamestate
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Condition import Condition
import numpy as np

class ANDCondition(Condition):
    """ The AND Condition holds when all of the included conditions hold. """

    def __init__(self, conditions: List[Condition]):
        """ Constructor of the AND Condition.

        Arguments:
            conditions: A list of included conditions of this AND Condition of which all must hold to make the entire
            condition hold.
        """
        self.conditions = conditions

    def fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        # Return a new game state with all conditions included in this condition appended in front of the condition
        # list of that game state.
        new_state = state.copy()
        new_state.conditions = self.conditions + state.conditions
        return [new_state]

    def opposite(self) -> Condition:
        opposite_conditions = [condition.opposite() for condition in self.conditions]
        return ORCondition(opposite_conditions)