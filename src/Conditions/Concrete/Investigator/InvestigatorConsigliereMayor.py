from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class InvestigatorConsigliereMayor(InvestigatorCondition):
    """ The Investigator Consigliere Mayor condition is used if someone pops up as Investigator, Consigliere or Mayor
    when you investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(player_id, frozenset({Role.INVESTIGATOR, Role.CONSIGLIERE, Role.MAYOR}), witched,
                         amnesiacRemembered)