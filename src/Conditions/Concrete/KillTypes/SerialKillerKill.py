from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class SerialKillerKill(ExistenceCondition):
    """ The Serial Killer Kill condition is used if some player was killed by a Serial Killer. """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.SERIALKILLER}), amnesiacRemembered)