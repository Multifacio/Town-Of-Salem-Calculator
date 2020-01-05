from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG

class Gamemodus:
    """ All possible Gamemodi which can be played in Town of Salem. """
    CLASSIC = [frozenset({Role.SHERIFF}), frozenset({Role.DOCTOR}), frozenset({Role.INVESTIGATOR}),
        frozenset({Role.JAILOR}), frozenset({Role.MEDIUM}), frozenset({Role.GODFATHER}), frozenset({Role.FRAMER}),
        frozenset({Role.EXECUTIONER}), frozenset({Role.ESCORT}), frozenset({Role.MAFIOSO}), frozenset({Role.LOOKOUT}),
        frozenset({Role.SERIALKILLER}), RG.NC_TOWN_KILLING, frozenset({Role.JESTER}), RG.NC_TOWN]

    OLD_RANKED_PRACTICE = [frozenset({Role.JAILOR}), RG.NC_TOWN_INVESTIGATIVE, RG.NC_TOWN_INVESTIGATIVE,
        RG.NC_TOWN_SUPPORT, RG.NC_TOWN_SUPPORT, RG.NC_TOWN_PROTECTIVE, RG.NC_TOWN_KILLING, RG.NC_TOWN,
        frozenset({Role.GODFATHER}), frozenset({Role.MAFIOSO}), RG.NC_MAFIA, RG.NC_NEUTRAL_KILLING, RG.NC_NEUTRAL_EVIL,
        RG.NC_NEUTRAL_BENIGN, RG.NC_ALL]

    NEW_RANKED_PRACTICE = [frozenset({Role.JAILOR}), RG.NC_TOWN_INVESTIGATIVE, RG.NC_TOWN_INVESTIGATIVE, RG.NC_TOWN_PROTECTIVE,
        RG.NC_TOWN_KILLING, RG.NC_TOWN_SUPPORT, RG.NC_TOWN, RG.NC_TOWN, RG.NC_TOWN, frozenset({Role.GODFATHER}),
        frozenset({Role.MAFIOSO}), RG.NC_MAFIA, RG.NC_MAFIA, RG.NC_NEUTRAL_EVIL, RG.NC_NEUTRAL_KILLING]

    RANKED = [frozenset({Role.JAILOR}), RG.NC_TOWN_INVESTIGATIVE, RG.NC_TOWN_INVESTIGATIVE, RG.NC_TOWN_PROTECTIVE,
        RG.NC_TOWN_KILLING, RG.NC_TOWN_SUPPORT, RG.NC_TOWN, RG.NC_TOWN, RG.NC_TOWN, frozenset({Role.GODFATHER}),
        frozenset({Role.MAFIOSO}), RG.NC_MAFIA, RG.NC_MAFIA, RG.NC_NEUTRAL_EVIL, RG.NC_NEUTRAL_KILLING]