from __future__ import annotations
from typing import List, TYPE_CHECKING
from src.Conditions.Condition import Condition
import itertools as it
if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate

class ORCondition(Condition):
    """ The OR Condition holds when one of the included conditions hold. """

    def __init__(self, conditions: List[Condition]):
        """ Constructor of the OR Condition.

        Arguments:
            conditions: A list of included conditions of this OR Condition of which one must hold to make the entire
            condition hold.
        """
        self.conditions = conditions

    def valid_skip(self, state: Gamestate):
        for con in self.conditions:
            if con.valid_skip(state):
                return True
        return False

    def inner_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        from src.Conditions.Abstract.ANDCondition import ANDCondition
        if self.valid_skip(state):
            return [state.copy()]

        new_states = []
        for bool_sample in it.product([False, True], repeat = len(self.conditions)):
            if any(bool_sample):
                condition_sample = [cond if b else cond.opposite() for b, cond in zip(bool_sample, self.conditions)]
                new_state = state.copy()
                new_state.conditions.insert(0, ANDCondition(condition_sample))
                new_states.append(new_state)
        return new_states

    def opposite(self) -> Condition:
        from src.Conditions.Abstract.ANDCondition import ANDCondition
        opposite_conditions = [condition.opposite() for condition in self.conditions]
        return ANDCondition(opposite_conditions)

    def priority(self) -> float:
        if len(self.conditions) > 1:
            return 20.0 / len(self.conditions)
        else:
            return 100.0