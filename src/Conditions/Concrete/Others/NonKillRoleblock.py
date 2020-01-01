from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class NonKillRoleblock(ORCondition):
    """ The Non Kill Roleblock condition is used when you jail (as Jailor) or roleblock (as Escort or Consort) a
    player and that player does not kill you (so you were not killed by a Werewolf or Serial Killer). This condition
    cannot be used if you are witched."""

    def __init__(self, player_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Non Kill Roleblock condition.

        Arguments:
            player_id (int): The id of the player that was jailed or roleblocked.
            full_moon (bool): True if that night was a full moon night (even night). False otherwise (odd night).
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = RG.NC_ALL.difference(frozenset({Role.SERIALKILLER}))
        if full_moon:
            roles = roles.difference(frozenset({Role.WEREWOLF}))

        super().__init__([ExistenceCondition(frozenset({Role.TRANSPORTER}), amnesiacRemembered),
                          PlayerIsRoleCondition(player_id, RG.become_include(roles, amnesiacRemembered))])

    def priority(self) -> float:
        return -1.0