from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from typing import FrozenSet

class ExcludeActualRoles(PlayerIsRoleCondition):
    """ Use the Exclude Actual Roles condition when a players actual role cannot be some given roles. Do not create
    separate Exclude Actual Roles conditions for the same player, but combine all excluded roles into 1 Exclude Actual
    Roles condition for that player (this has to do with differences between the starting and actual role). """

    def __init__(self, player_id: int, excluded_roles: FrozenSet[Role], amnesiacRemembered: FrozenSet[Role] = None):
        """ The constructor of the Exclude Actual Roles condition.

        Arguments:
            player_id (int): The id of the player of which we know that it cannot have some given actual roles.
            excluded_roles (FrozenSet[Role]): All the actual roles this player cannot have.
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = RG.NC_ALL.difference(excluded_roles)
        super().__init__(player_id, RG.become_include(roles, amnesiacRemembered))