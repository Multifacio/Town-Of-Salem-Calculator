from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition

class Blackmailed(ExistenceCondition):
    """ The Blackmailed condition is used when at then end of the night you got the message that you are blackmailed,
    i.e. you received the message: 'Someone threatened to reveal your secrets. You were blackmailed' """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.BLACKMAILER}), amnesiacRemembered)