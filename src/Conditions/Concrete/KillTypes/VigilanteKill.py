from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class VigilanteKill(ExistenceCondition):
    """ The Vigilante Kill condition is used if some player was killed by a Vigilante. """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.VIGILANTE}), amnesiacRemembered)