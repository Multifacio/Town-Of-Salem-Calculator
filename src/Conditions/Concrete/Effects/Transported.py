from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Transported(ExistenceCondition):
    """ The Transported condition is used when during the night you were transported (by a Transported), i.e. you
    received the message: 'You were transported to another location' """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.TRANSPORTER}), amnesiacRemembered)