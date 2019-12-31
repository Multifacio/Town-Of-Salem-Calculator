from src.Concepts.Role import Role
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class ActiveMedium(ExistenceCondition):
    """ The Active Medium condition is used when a Medium talks in the death chat. If the Medium reveals his name then
    you should use the Actual Role condition instead. """

    def __init__(self, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(frozenset({Role.MEDIUM}), amnesiacRemembered)