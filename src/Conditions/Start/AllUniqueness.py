from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.AtMostCondition import AtMostCondition

class AllUniqueness(ANDCondition):
    """ The All Uniqueness Condition enforces that all unique roles should occur at most once. """

    def __init__(self):
        super().__init__([AtMostCondition(frozenset({role}), 1) for role in RG.NC_UNIQUE])