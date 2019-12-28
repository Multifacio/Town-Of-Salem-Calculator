from typing import Set
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class SheriffExecutionerWerewolf(InvestigatorCondition):
    """ The Sheriff Executioner Werewolf condition is used if someone pops up as Sheriff, Executioner or Werewolf when
    you investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: Set[Role] = None):
        super().__init__(player_id, {Role.SHERIFF, Role.EXECUTIONER, Role.WEREWOLF}, witched, amnesiacRemembered)