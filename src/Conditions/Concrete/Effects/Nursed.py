from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Nursed(ExistenceCondition):
    """ The Nursed condition is used when during the night you were attacked but also healed by a Doctor, i.e.
    you received the message: 'You were attacked but someone nursed you back to health' """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.DOCTOR}), amnesiacRemembered)