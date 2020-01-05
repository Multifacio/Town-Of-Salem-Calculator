from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Witched(ExistenceCondition):
    """ The Witched condition is used when during the night you were controlled by a Witch, i.e. you received the
    message: 'You feel a mystical power dominating you. You were controlled by a Witch!' """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.WITCH}), amnesiacRemembered)