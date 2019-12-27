from typing import List
from src.Mechanics.Gamestate import Gamestate
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Condition import Condition
import itertools as it

class ORCondition(Condition):
    """ The OR Condition holds when one of the included conditions hold. """

    def __init__(self, conditions: List[Condition]):
        """ Constructor of the OR Condition.

        Arguments:
            conditions: A list of included conditions of this OR Condition of which one must hold to make the entire
            condition hold.
        """
        self.conditions = conditions

    def fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        new_states = []
        for bool_sample in it.product([False, True], repeat = len(self.conditions)):
            if any(bool_sample):
                condition_sample = [cond if b else cond.opposite() for b, cond in zip(bool_sample, self.conditions)]
                new_state = state.copy()
                new_state.conditions.insert(0, ANDCondition(condition_sample))
                new_states.append(new_state)
        return new_states

    def opposite(self) -> Condition:
        opposite_conditions = [condition.opposite() for condition in self.conditions]
        return ANDCondition(opposite_conditions)