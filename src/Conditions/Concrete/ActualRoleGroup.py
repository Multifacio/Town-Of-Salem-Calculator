from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from typing import FrozenSet

class ActualRoleGroup(PlayerIsRoleCondition):
    """ The Actual Role Group condition is used to check if a players role belongs to a certain set of roles. """

    def __init__(self, player_id: int, roles: FrozenSet[Role], amnesiacRemembered: FrozenSet[Role] = None):
        """" Constructor of the Actual Role condition.

        Arguments:
            player_id (int): The id of the player of which we want to check if it belongs to a certain set of roles.
            roles (Role): The possible roles for this player.
            amnesiacRemembered (Set[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        super().__init__(player_id, RG.become_include(roles, amnesiacRemembered))
