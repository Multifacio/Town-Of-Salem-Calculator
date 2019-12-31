from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class ArsonistKill(ExistenceCondition):
    """ The Arsonist Kill condition is used if during the day it is revealed that other players have been ignited. """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.ARSONIST}), amnesiacRemembered)