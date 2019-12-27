from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Start.AllUniqueness import AllUniqueness
from src.Conditions.Start.MafiaLimit import MafiaLimit
from src.Conditions.Start.VampireHunterExistence import VampireHunterExistence
from src.Conditions.Start.VampireLimit import VampireLimit

class StartCondition(ANDCondition):
    """ The Start Condition contains all condition that hold at the beginning of every game which are not enforced by
    the game mechanics. """

    def __init__(self):
        super().__init__([AllUniqueness(), VampireHunterExistence(), MafiaLimit(), VampireLimit()])