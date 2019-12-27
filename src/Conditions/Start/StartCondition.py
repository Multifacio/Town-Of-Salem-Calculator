from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Start.AllUniqueness import AllUniqueness

class StartCondition(ANDCondition):
    """ The Start Condition contains all condition that hold at the beginning of every game which are not enforced by
    the game mechanics. """

    def __init__(self):
        super().__init__([AllUniqueness()])