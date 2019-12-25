from __future__ import annotations
from aenum import Enum, NoAlias

class Role(Enum):
    """ Representation of all roles in Town of Salem. """
    _settings_ = NoAlias

    # All Town Roles
    BODYGUARD = "Bodyguard"
    DOCTOR = "Doctor"
    ESCORT = "Escort"
    INVESTIGATOR = "Investigator"
    JAILOR = "Jailor"
    LOOKOUT = "Lookout"
    MAYOR = "Mayor"
    MEDIUM = "Medium"
    RETRIBUTIONIST = "Retributionist"
    SHERIFF = "Sheriff"
    SPY = "Spy"
    TRANSPORTER = "Transporter"
    VAMPIREHUNTER = "Vampire Hunter"
    VETERAN = "Veteran"
    VIGILANTE = "Vigilante"

    # All Mafia Roles
    BLACKMAILER = "Blackmailer"
    CONSIGLIERE = "Consigliere"
    CONSORT = "Consort"
    DISGUISER = "Disguiser"
    FORGER = "Forger"
    FRAMER = "Framer"
    GODFATHER = "Godfather"
    JANITOR = "Janitor"
    MAFIOSO = "Mafioso"

    # All Neutral Roles
    AMNESIAC = "Amnesiac"
    ARSONIST = "Arsonist"
    EXECUTIONER = "Executioner"
    JESTER = "Jester"
    SERIALKILLER = "SerialKiller"
    SURVIVOR = "Survivor"
    VAMPIRE = "Vampire"
    WEREWOLF = "Werewolf"
    WITCH = "Witch"