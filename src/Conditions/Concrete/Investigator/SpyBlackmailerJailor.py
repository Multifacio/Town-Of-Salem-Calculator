from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class SpyBlackmailerJailor(InvestigatorCondition):
    """ The Spy Blackmailer Jailor condition is used if someone pops up as Spy, Blackmailer or Jailor when you
    investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(player_id, frozenset({Role.SPY, Role.BLACKMAILER, Role.JAILOR}), witched, amnesiacRemembered)