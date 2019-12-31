from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class WerewolfKill(ExistenceCondition):
    """ The Werewolf Kill condition is used if some player was killed by a Werewolf. """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.WEREWOLF}), amnesiacRemembered)