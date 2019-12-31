from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Cleaned(ExistenceCondition):
    """ The Cleaned condition is used if some player died and was cleaned (by a Janitor). """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.JANITOR}), amnesiacRemembered)