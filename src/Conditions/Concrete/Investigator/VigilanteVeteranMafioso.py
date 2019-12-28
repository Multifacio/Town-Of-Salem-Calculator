from typing import Set
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class VigilanteVeteranMafioso(InvestigatorCondition):
    """ The Vigilante Veteran Mafioso condition is used if someone pops up as Vigilante, Veteran or Mafioso when you
    investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: Set[Role] = None):
        super().__init__(player_id, {Role.VIGILANTE, Role.VETERAN, Role.MAFIOSO}, witched, amnesiacRemembered)