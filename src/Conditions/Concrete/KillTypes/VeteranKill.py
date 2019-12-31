from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class VeteranKill(ExistenceCondition):
    """ The Veteran Kill condition is used if some player was killed by a Veteran. """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.VETERAN}), amnesiacRemembered)