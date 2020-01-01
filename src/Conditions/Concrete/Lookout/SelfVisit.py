from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from src.Conditions.Concrete.Lookout.OtherVisit import OtherVisit
from typing import FrozenSet

class SelfVisit(ORCondition):
    """ The Self Visit condition is used when a Lookout sees a player visiting himself. Combine this condition with
    the Exclude Actual Role condition if you do not die by a Veteran or Werewolf visiting itself when you watch that
    player as Lookout. Also the player visiting itself cannot be a Vigilante or Mafioso if it was the only person
    visiting itself, because then that player would have died. """

    # All the roles that can visit themselves without help of a Witch.
    NORMAL_SELF_VISITERS = frozenset({Role.ARSONIST, Role.TRANSPORTER, Role.VETERAN, Role.WEREWOLF})

    def __init__(self, player_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Self Visit condition.

        Arguments:
           player_id (int): The id of the player that visited himself.
           full_moon (bool): True if that night was a full moon night (even night). False otherwise (odd night).
           amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = self.NORMAL_SELF_VISITERS
        if not full_moon:
            roles = roles.difference(frozenset({Role.WEREWOLF}))

        super().__init__(
            [ANDCondition([ExistenceCondition(frozenset({Role.WITCH}), amnesiacRemembered),
                PlayerIsRoleCondition(player_id, RG.become_include(OtherVisit.WITCH_VISITERS, amnesiacRemembered))]),
            PlayerIsRoleCondition(player_id, RG.become_include(roles, amnesiacRemembered))])

    def priority(self) -> float:
        return 2.0