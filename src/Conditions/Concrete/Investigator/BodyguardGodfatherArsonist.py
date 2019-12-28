from typing import Set
from src.Concepts.Role import Role
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class BodyguardGodfatherArsonist(ORCondition):
    """ The Bodyguard Godfather Arsonist condition is used if someone pops up as Bodyguard, Godfather or Arsonist when
    you investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: Set[Role] = None):
        super().__init__([AtLeastCondition({Role.ARSONIST}, 1), InvestigatorCondition(player_id,
                {Role.BODYGUARD, Role.GODFATHER, Role.ARSONIST}, witched, amnesiacRemembered)])