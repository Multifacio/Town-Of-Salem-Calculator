from src.Concepts.Role import Role
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Abstract.AtMostCondition import AtMostCondition
from src.Conditions.Abstract.ORCondition import ORCondition

class VampireHunterExistence(ORCondition):
    """ Vampire Hunter Existence enforces that there can only be a Vampire Hunter if there is a Vampire. """

    def __init__(self):
        super().__init__([AtMostCondition(frozenset({Role.VAMPIREHUNTER}), 0),
                          AtLeastCondition(frozenset({Role.VAMPIRE}), 1)])

    def priority(self) -> float:
        return 30.0