from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from typing import FrozenSet

class TownHostile(PlayerIsRoleCondition):
    """ The Town Hostile condition is used for checking if players should be lynched or killed by Town. It contains all
    roles that should be eliminated before Town wins which includes the Mafia, Neutral Killing roles and the Witch. """

    TOWN_HOSTILE_ROLES = frozenset.union(RG.NC_MAFIA, RG.NC_NEUTRAL_KILLING, {Role.WITCH})

    def __init__(self, player_id: int, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Town Hostile condition.

        Arguments:
            player_id (int): The player of which we want to check if it belongs to the TOWN_HOSTILE group.
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        super().__init__(player_id, RG.become_include(self.TOWN_HOSTILE_ROLES, amnesiacRemembered))