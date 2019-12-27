from typing import Set
from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Concepts.Rolegroup import Rolegroup as RG

class DeathRole(ANDCondition):
    """ The Death Role condition is used when you know someones actual role because he died either by hanging or because
    he was killed during the night and was not cleaned by a Janitor. Do not use this condition if someone was cleaned. """

    def __init__(self, player_id: int, role: Role, amnesiacRemembered: Set[Role] = None):
        """" Constructor of the Death Role condition.

        Arguments:
            player_id (int): The id of the player that died.
            role (Role): The revealed role of the death player.
            amnesiacRemembered (Set[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = set()
        super().__init__([InnerDeathRole(player_id, role, amnesiacRemembered),
                          AtLeastCondition(RG.become_include({role}, amnesiacRemembered), 1)])

class InnerDeathRole(PlayerIsRoleCondition):
    def __init__(self, player_id: int, role: Role, amnesiacRemembered: Set[Role] = None):
        super().__init__(player_id, RG.full_include({role}, amnesiacRemembered))