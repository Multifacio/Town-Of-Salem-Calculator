from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from typing import FrozenSet

class Jailed(PlayerIsRoleCondition):
    """ The Jailed condition is used when your ability fails because your target was jailed (so your target cannot be
    the Jailor). This condition cannot be used if you are witched. """

    def __init__(self, player_id: int, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Jailed condition.

        Arguments:
            player_id (int): The id of the player that was jailed..
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        super().__init__(player_id, RG.become_include(RG.NC_ALL.difference(frozenset({Role.JAILOR})), amnesiacRemembered))