from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class MediumJanitorRetributionist(InvestigatorCondition):
    """ The Medium Janitor Retributionist condition is used if someone pops up as Medium, Janitor or Retributionist
    when you investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(player_id, frozenset({Role.MEDIUM, Role.JANITOR, Role.RETRIBUTIONIST}), witched,
                         amnesiacRemembered)