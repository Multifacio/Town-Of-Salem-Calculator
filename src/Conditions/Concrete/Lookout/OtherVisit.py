from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class OtherVisit(ORCondition):
    """ The Other Visit condition is used when a Lookout sees a player visiting another player and the target is
    visited by at least 2 players (excluding yourself). Use the Other Single Visit Harmless condition instead if only
    1 player visits your target and the target does not die. If the target dies but it is uncertain if the visiting
    player is the killer then you should also use this condition. Combine this condition with the Exclude Actual Role
    condition if you do not die by a Werewolf during Full Moon, because a Werewolf visiting a target during Full Moon
    will also kill you as Lookout if you watch that target. """

    # All visitable roles that can visit a player with or without the help of a Witch
    WITCH_VISITERS = frozenset({Role.AMNESIAC, Role.ARSONIST, Role.BLACKMAILER, Role.BODYGUARD, Role.CONSIGLIERE,
                                Role.CONSORT, Role.DISGUISER, Role.DOCTOR, Role.ESCORT, Role.FORGER, Role.FRAMER,
                                Role.GODFATHER, Role.INVESTIGATOR, Role.JAILOR, Role.JANITOR, Role.JESTER,
                                Role.LOOKOUT, Role.MAFIOSO, Role.MEDIUM, Role.RETRIBUTIONIST, Role.SERIALKILLER,
                                Role.SHERIFF, Role.SPY, Role.TRANSPORTER, Role.VAMPIRE, Role.VAMPIREHUNTER,
                                Role.VIGILANTE, Role.WEREWOLF, Role.WITCH})

    # All roles that can visit a player without the help of a witch and without getting the message that your Lookout
    # action failed, because your target was jailed (so Jailor is excluded from the Normal Visiters set).
    NORMAL_VISITERS = frozenset({Role.ARSONIST, Role.BLACKMAILER, Role.BODYGUARD, Role.CONSIGLIERE, Role.CONSORT,
                                 Role.DISGUISER, Role.DOCTOR, Role.ESCORT, Role.FORGER, Role.FRAMER, Role.GODFATHER,
                                 Role.INVESTIGATOR, Role.JANITOR, Role.LOOKOUT, Role.MAFIOSO, Role.SERIALKILLER,
                                 Role.SHERIFF, Role.SPY, Role.TRANSPORTER, Role.VAMPIRE, Role.VAMPIREHUNTER,
                                 Role.VIGILANTE, Role.WEREWOLF, Role.WITCH})

    def __init__(self, player_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Other Visit condition.

        Arguments:
           player_id (int): The id of the player that visited your target.
           full_moon (bool): True if that night was a full moon night (even night). False otherwise (odd night).
           amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = self.NORMAL_VISITERS
        if not full_moon:
            roles = roles.difference(frozenset({Role.WEREWOLF}))

        super().__init__(
            [ANDCondition([ExistenceCondition(frozenset({Role.WITCH}), amnesiacRemembered),
                PlayerIsRoleCondition(player_id, RG.become_include(self.WITCH_VISITERS, amnesiacRemembered))]),
            PlayerIsRoleCondition(player_id, RG.become_include(roles, amnesiacRemembered))])

    def priority(self) -> float:
        return 1.0