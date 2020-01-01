from typing import Set, FrozenSet
from src.Concepts.Role import Role

class Rolegroup:
    """ A class with Rolegroups (a frozenset of roles) variables and static functions that compute Rolegroups which are
    used in Gamemodi or conditions or predictions. """

    @staticmethod
    def full_include(roles: FrozenSet[Role], amnesiacRemembered: FrozenSet[Role]) -> FrozenSet[Role]:
        """ Include all roles that can become any role in a given set of roles and include the Disguiser.

        Arguments:
            roles (Set[Role]): A set of roles which we extend with the new roles.

        Returns:
            All the roles including the roles that can become any of these roles and including the Disguiser.
        """
        return Rolegroup.become_include(roles, amnesiacRemembered).union(frozenset({Role.DISGUISER}))

    @staticmethod
    def become_include(roles: FrozenSet[Role], amnesiacRemembered: FrozenSet[Role]) -> FrozenSet[Role]:
        """ Include all roles that can become any role in a given set of roles.

        Arguments:
            roles (Set[Role]): A set of roles which we extend with the new roles.

        Returns:
            All the roles including the roles that can become any of these roles.
        """
        result = set()
        result.update(roles)
        for role in roles:
            result.update(Rolegroup.NC_CAN_BECOME.get(role, frozenset()))
        if not result.isdisjoint(amnesiacRemembered):
            result.add(Role.AMNESIAC)
        return frozenset(result)

    # Gamemodus Rolegroups (rolegroups used in Gamemodi to fill in the start categories)
    # All Non-Coven Town Rolegroups
    NC_TOWN_INVESTIGATIVE = frozenset({Role.INVESTIGATOR, Role.LOOKOUT, Role.SHERIFF, Role.SPY})
    NC_TOWN_KILLING = frozenset({Role.JAILOR, Role.VAMPIREHUNTER, Role.VETERAN, Role.VIGILANTE})
    NC_TOWN_PROTECTIVE = frozenset({Role.BODYGUARD, Role.DOCTOR})
    NC_TOWN_SUPPORT = frozenset({Role.ESCORT, Role.MAYOR, Role.MEDIUM, Role.RETRIBUTIONIST, Role.TRANSPORTER})
    NC_TOWN = frozenset.union(NC_TOWN_INVESTIGATIVE, NC_TOWN_KILLING, NC_TOWN_PROTECTIVE, NC_TOWN_SUPPORT)

    # All Non-Coven Mafia Rolegroups
    NC_MAFIA_DECEPTION = frozenset({Role.DISGUISER, Role.FORGER, Role.FRAMER, Role.JANITOR})
    NC_MAFIA_KILLING = frozenset({Role.GODFATHER, Role.MAFIOSO})
    NC_MAFIA_SUPPORT = frozenset({Role.BLACKMAILER, Role.CONSIGLIERE, Role.CONSORT})
    NC_MAFIA = frozenset.union(NC_MAFIA_DECEPTION, NC_MAFIA_KILLING, NC_MAFIA_SUPPORT)

    # All Non-Coven Neutral Rolegroups
    NC_NEUTRAL_BENIGN = frozenset({Role.AMNESIAC, Role.SURVIVOR})
    NC_NEUTRAL_CHAOS = frozenset({Role.VAMPIRE})
    NC_NEUTRAL_EVIL = frozenset({Role.JESTER, Role.EXECUTIONER, Role.WITCH})
    NC_NEUTRAL_KILLING = frozenset({Role.ARSONIST, Role.SERIALKILLER, Role.WEREWOLF})
    NC_NEUTRAL = frozenset.union(NC_NEUTRAL_BENIGN, NC_NEUTRAL_CHAOS, NC_NEUTRAL_EVIL, NC_NEUTRAL_KILLING)

    NC_ALL = frozenset.union(NC_TOWN, NC_MAFIA, NC_NEUTRAL)

    # All Non-Coven can become Rolegroups (keys in the dictionary are the roles which another role can become, the
    # values are the roles which can directly/indirectly become this role)
    NC_CAN_BECOME = {Role.GODFATHER: frozenset({Role.MAFIOSO}),
                     Role.MAFIOSO: NC_MAFIA.difference(frozenset({Role.GODFATHER, Role.MAFIOSO})),
                     Role.VIGILANTE: frozenset({Role.VAMPIREHUNTER}),
                     Role.JESTER: frozenset({Role.EXECUTIONER})}

    # Prediction Rolegroups (we want to determine if a player is part of these groups)
    # All roles that should be killed before town wins
    NC_TOWN_HOSTILE = frozenset.union(NC_MAFIA, NC_NEUTRAL_KILLING, {Role.WITCH})
    NC_TOWN_NON_HOSTILE = NC_ALL.difference(NC_TOWN_HOSTILE) # All roles that do not need to be killed to have town win