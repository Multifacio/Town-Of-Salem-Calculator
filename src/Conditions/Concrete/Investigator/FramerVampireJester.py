from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition

class FramerVampireJester(ORCondition):
    """ The Framer Vampire Jester condition is used if someone pops up as Framer, Vampire or Jester when you investigate
    that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__([ExistenceCondition(frozenset({Role.FRAMER}), amnesiacRemembered),
            InvestigatorCondition(player_id, frozenset({Role.FRAMER, Role.VAMPIRE, Role.JESTER}), witched,
                                  amnesiacRemembered)])

    def priority(self) -> float:
        return 10.0