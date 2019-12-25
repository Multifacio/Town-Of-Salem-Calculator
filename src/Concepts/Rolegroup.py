from src.Concepts.Role import Role

class Rolegroup:
    """ A class with only Rolegroups variables (a set of roles) used in Gamemodi or conditions or predictions. """

    # Gamemodus Rolegroups (rolegroups used in Gamemodi to fill in the start categories)
    # All Non-Coven Town Rolegroups
    NC_TOWN_INVESTIGATIVE = {Role.INVESTIGATOR, Role.LOOKOUT, Role.SHERIFF, Role.SPY}
    NC_TOWN_KILLING = {Role.JAILOR, Role.VAMPIREHUNTER, Role.VETERAN, Role.VIGILANTE}
    NC_TOWN_PROTECTIVE = {Role.BODYGUARD, Role.DOCTOR}
    NC_TOWN_SUPPORT = {Role.ESCORT, Role.MAYOR, Role.MEDIUM, Role.RETRIBUTIONIST, Role.TRANSPORTER}
    NC_TOWN = set.union(NC_TOWN_INVESTIGATIVE, NC_TOWN_KILLING, NC_TOWN_PROTECTIVE, NC_TOWN_SUPPORT)

    # All Non-Coven Mafia Rolegroups
    NC_MAFIA_DECEPTION = {Role.DISGUISER, Role.FORGER, Role.FRAMER, Role.JANITOR}
    NC_MAFIA_KILLING = {Role.GODFATHER, Role.MAFIOSO}
    NC_MAFIA_SUPPORT = {Role.BLACKMAILER, Role.CONSIGLIERE, Role.CONSORT}
    NC_MAFIA = set.union(NC_MAFIA_DECEPTION, NC_MAFIA_KILLING, NC_MAFIA_SUPPORT)

    # All Non-Coven Neutral Rolegroups
    NC_NEUTRAL_BENIGN = {Role.AMNESIAC, Role.SURVIVOR}
    NC_NEUTRAL_CHAOS = {Role.VAMPIRE}
    NC_NEUTRAL_EVIL = {Role.JESTER, Role.EXECUTIONER, Role.WITCH}
    NC_NEUTRAL_KILLING = {Role.ARSONIST, Role.SERIALKILLER, Role.WEREWOLF}
    NC_NEUTRAL = set.union(NC_NEUTRAL_BENIGN, NC_NEUTRAL_CHAOS, NC_NEUTRAL_EVIL, NC_NEUTRAL_KILLING)

    NC_ALL = set.union(NC_TOWN, NC_MAFIA, NC_NEUTRAL)

    # All Non-Coven can become Rolegroups (keys in the dictionary are the roles which another role can become, the
    # values are the roles which can become this role)
    NC_CAN_BECOME = {Role.GODFATHER: {Role.MAFIOSO}, Role.MAFIOSO: NC_MAFIA.difference({Role.GODFATHER, Role.MAFIOSO}),
                     Role.VIGILANTE: {Role.VAMPIREHUNTER}, Role.JESTER: {Role.EXECUTIONER}}

    # Prediction Rolegroups (we want to determine if a player is part of these groups)
    NC_TOWN_HOSTILE = set.union(NC_MAFIA, NC_NEUTRAL_KILLING, {Role.WITCH}) # All roles that should be killed before town wins
    NC_TOWN_NON_HOSTILE = NC_ALL.difference(NC_TOWN_HOSTILE) # All roles that do not need to be killed to have town win

    # Condition Rolegroups (Rolegroups which are given by a condition)
    NC_IN_JAIL_GROUP = NC_ALL.difference({Role.JAILOR}) # All roles that can be jailed
    # All roles that can be roleblocked without resulting in a kill of the roleblocker
    NC_SUCCESSFUL_ROLEBLOCK = NC_ALL.difference({Role.SERIALKILLER})
    # All roles with basic defense
    NC_BASIC_DEFENSE = {Role.BODYGUARD, Role.GODFATHER, Role.SURVIVOR, Role.EXECUTIONER, Role.WITCH, Role.ARSONIST,
                        Role.SERIALKILLER, Role.WEREWOLF}
    # All roles that can visit someone else excluding the situation where players are controlled by a witch.
    NC_OTHER_VISIT = {Role.INVESTIGATOR, Role.LOOKOUT, Role.SHERIFF, Role.SPY, Role.VAMPIREHUNTER, Role.VIGILANTE,
                      Role.BODYGUARD, Role.DOCTOR, Role.ESCORT, Role.TRANSPORTER, Role.DISGUISER, Role.FORGER,
                      Role.FRAMER, Role.JANITOR, Role.GODFATHER, Role.MAFIOSO, Role.BLACKMAILER, Role.CONSIGLIERE,
                      Role.CONSORT, Role.WITCH, Role.VAMPIRE, Role.ARSONIST, Role.SERIALKILLER, Role.WEREWOLF}
    # All roles that can visit themselves without killing the lookout that watches them and excluding the situation where
    # players are controlled by a witch or redirected by a transporter.
    NC_SELF_VISIT_WITHOUT_KILL = {Role.BODYGUARD, Role.DOCTOR, Role.TRANSPORTER, Role.SURVIVOR, Role.ARSONIST}