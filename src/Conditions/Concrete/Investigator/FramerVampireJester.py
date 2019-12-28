from typing import Set
from src.Concepts.Role import Role
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class FramerVampireJester(ORCondition):
    """ The Framer Vampire Jester condition is used if someone pops up as Framer, Vampire or Jester when you investigate
    that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: Set[Role] = None):
        super().__init__([AtLeastCondition({Role.FRAMER}, 1), InvestigatorCondition(player_id,
                {Role.FRAMER, Role.VAMPIRE, Role.JESTER}, witched, amnesiacRemembered)])