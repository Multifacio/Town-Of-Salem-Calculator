from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from src.Conditions.Concrete.Lookout.OtherVisit import OtherVisit
from typing import FrozenSet

class OtherSingleVisitHarmless(ORCondition):
    """ The Other Single Visit Harmless condition is used when a Lookout sees that a player is visited by exactly 1
    other player (excluding you as Lookout) and the visited player does not die. """

    # All roles with basic attack or higher that visit their target with an attack (except Jailor, because then you
    # would receive a Jailed message)
    ATTACK_ROLES = frozenset({Role.VIGILANTE, Role.SERIALKILLER, Role.MAFIOSO, Role.GODFATHER, Role.WEREWOLF})

    def __init__(self, target_id: int, visiter_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Other Single Visit Harmless condition.

        Arguments:
            target_id (int): The id of the player that was being visited by someone else
            visiter_id (int): The id of the player that visited the player with the target_id
            full_moon (bool): True if that night was a full moon night (even night). False otherwise (odd night).
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        super().__init__([NonDefenseNormalCase(visiter_id, amnesiacRemembered),
                          NonDefenseWitchCase(visiter_id, full_moon, amnesiacRemembered),
                          DefenseCase(target_id, visiter_id, amnesiacRemembered)])

    def priority(self) -> float:
        return -2.0

class NonDefenseNormalCase(PlayerIsRoleCondition):
    def __init__(self, visiter_id: int, amnesiacRemembered: FrozenSet[Role]):
        roles = OtherVisit.NORMAL_VISITERS.difference(OtherSingleVisitHarmless.ATTACK_ROLES)
        super().__init__(visiter_id, RG.become_include(roles, amnesiacRemembered))

class NonDefenseWitchCase(ANDCondition):
    def __init__(self, visiter_id: int, full_moon: bool, amnesiacRemembered: FrozenSet[Role]):
        roles = OtherVisit.WITCH_VISITERS.difference(OtherSingleVisitHarmless.ATTACK_ROLES)
        if not full_moon:
            roles = roles.union(frozenset({Role.WEREWOLF}))

        super().__init__([ExistenceCondition(frozenset({Role.WITCH}), amnesiacRemembered),
                          PlayerIsRoleCondition(visiter_id, RG.become_include(roles, amnesiacRemembered))])

class DefenseCase(ANDCondition):
    # All roles with basic attack that always kill their target if it does not have basic defense or higher
    BASIC_ATTACK_ROLES = frozenset({Role.VIGILANTE, Role.SERIALKILLER, Role.MAFIOSO, Role.GODFATHER})

    # All roles with basic defense and the Doctor role.
    DEFENSE_ROLES = frozenset({Role.BODYGUARD, Role.DOCTOR, Role.GODFATHER, Role.SURVIVOR, Role.EXECUTIONER,
                               Role.WITCH, Role.ARSONIST, Role.SERIALKILLER, Role.WEREWOLF})

    def __init__(self, target_id: int, visiter_id: int, amnesiacRemembered: FrozenSet[Role]):
        super().__init__([PlayerIsRoleCondition(visiter_id, RG.become_include(self.BASIC_ATTACK_ROLES, amnesiacRemembered)),
                          PlayerIsRoleCondition(target_id, RG.become_include(self.DEFENSE_ROLES, amnesiacRemembered))])
