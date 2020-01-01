from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from src.Conditions.Concrete.Sheriff.Suspicious import Suspicious
from typing import FrozenSet

class NotSuspicious(ORCondition):
    """ The Not Suspicious condition is used when a Sheriff interrogation results in innocence, i.e. you received the
    message: 'You cannot find evidence of wrongdoing. Your target seems innocent.' This condition cannot be used if you
    are witched. """

    def __init__(self, player_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Not Suspicious condition.

        Arguments:
            player_id (int): The id of the player that was interrogated.
            full_moon (bool): True if that night was a full moon night (even night). False otherwise (odd night).
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = RG.NC_ALL.difference(Suspicious.SUSPICIOUS_ROLES)
        if full_moon:
            roles = roles.difference(frozenset({Role.WEREWOLF}))

        super().__init__([ExistenceCondition(frozenset({Role.TRANSPORTER}), amnesiacRemembered),
                          PlayerIsRoleCondition(player_id, RG.become_include(roles, amnesiacRemembered))])

    def priority(self) -> float:
        return 3.0