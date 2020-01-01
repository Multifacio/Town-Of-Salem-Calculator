from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class BasicDefense(ORCondition):
    """ The Basic Defense condition is used when you try to attack a player as Vigilante, Mafia, Serial Killer or any
    other role with Basic Attack and you received the message: 'Your target's defense was too strong to kill'
    This condition cannot be used if you are witched. """

    BASIC_DEFENSE_ROLES = frozenset({Role.BODYGUARD, Role.GODFATHER, Role.SURVIVOR, Role.EXECUTIONER, Role.WITCH,
                               Role.ARSONIST, Role.SERIALKILLER, Role.WEREWOLF})

    def __init__(self, player_id: int, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Basic Defense condition.

        Arguments:
            player_id (int): The id of the player with Basic Defense
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        super().__init__([ExistenceCondition(frozenset({Role.TRANSPORTER}), amnesiacRemembered),
                PlayerIsRoleCondition(player_id, RG.become_include(self.BASIC_DEFENSE_ROLES, amnesiacRemembered))])

    def priority(self) -> float:
        return 15.0