from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Roleblocked(ExistenceCondition):
    """ The Roleblocked condition is used when during the night you were roleblocked (either by an Escort or Consort),
    i.e. you received the message: 'Someone occupied your night. You were role blocked' """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.ESCORT, Role.CONSORT}), amnesiacRemembered)