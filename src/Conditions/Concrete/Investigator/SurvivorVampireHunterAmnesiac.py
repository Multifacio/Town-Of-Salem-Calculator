from typing import Set
from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class SurvivorVampireHunterAmnesiac(InvestigatorCondition):
    """ The Survivor Vampire Hunter Amnesiac condition is used if someone pops up as Survivor, Vampire Hunter or
    Amnesiac when you investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: Set[Role] = None):
        super().__init__(player_id, {Role.SURVIVOR, Role.VAMPIREHUNTER, Role.AMNESIAC}, witched, amnesiacRemembered)