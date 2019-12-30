from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class LookoutForgerWitch(InvestigatorCondition):
    """ The Lookout Forger Witch condition is used if someone pops up as Lookout, Forger or Witch when you investigate
    that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(player_id, frozenset({Role.LOOKOUT, Role.FORGER, Role.WITCH}), witched, amnesiacRemembered)