from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from typing import FrozenSet

class ExistenceCondition(AtLeastCondition):
    """ The Existence Condition is used when you got some indication that some roles (actual role not starting role)
    exists in the game. """

    def __init__(self, roles: FrozenSet[Role], amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Existence Condition.

        Arguments:
            roles (FrozenSet[Role]): Either 1 of the roles in this set of roles should exists (occurs at least once)
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()
        super().__init__(RG.become_include(roles, amnesiacRemembered), 1)