from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Resurrected(ExistenceCondition):
    """ The Resurrected condition is used when a Town member is resurrected by a Retributionist (do not forget to use
    the Actual Role condition on the resurrected person, because he cannot be a Disguiser anymore). """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.RETRIBUTIONIST}), amnesiacRemembered)