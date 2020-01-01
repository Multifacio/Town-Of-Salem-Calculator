from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class Suspicious(ORCondition):
    """ The Suspicious condition is used when a Sheriff interrogation results in suspicious, i.e. you received the
    message: 'Your target is suspicious.' This condition cannot be used if you are witched. """

    # All Suspicious Roles during a non full moon night
    SUSPICIOUS_ROLES = frozenset.union(RG.NC_MAFIA.difference(frozenset({Role.GODFATHER})),
                                       frozenset({Role.SERIALKILLER}))

    def __init__(self, player_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Suspicious condition.

        Arguments:
            player_id (int): The id of the player that was interrogated.
            full_moon (bool): True if that night was a full moon night (even night). False otherwise (odd night).
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = self.SUSPICIOUS_ROLES
        if full_moon:
            roles = roles.union({Role.WEREWOLF})

        super().__init__([ExistenceCondition(frozenset({Role.TRANSPORTER}), amnesiacRemembered),
                          ExistenceCondition(frozenset({Role.FRAMER}), amnesiacRemembered),
                          PlayerIsRoleCondition(player_id, RG.become_include(roles, amnesiacRemembered))])

    def priority(self) -> float:
        return 4.0