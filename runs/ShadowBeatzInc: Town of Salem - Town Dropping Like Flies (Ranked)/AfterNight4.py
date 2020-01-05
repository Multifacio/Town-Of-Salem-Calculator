from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Concrete.Effects.Witched import Witched
from src.Conditions.Concrete.Investigator.DoctorDisguiserSerialKiller import DoctorDisguiserSerialKiller
from src.Conditions.Concrete.Investigator.VigilanteVeteranMafioso import VigilanteVeteranMafioso
from src.Conditions.Concrete.KillTypes.SerialKillerKill import SerialKillerKill
from src.Conditions.Concrete.KillTypes.VigilanteKill import VigilanteKill
from src.Conditions.Concrete.RoleKnown.ActualRole import ActualRole
from src.Conditions.Concrete.RoleKnown.DeathRole import DeathRole
from src.Conditions.Concrete.TownHostile import TownHostile
from src.Mechanics.Analyzer import Analyzer
from src.Concepts.Gamemodus import Gamemodus as GM

# Likelihood After Night 4, so only the event during night 4 are used as evidence (which includes the players that
# died during this night, but does not include the role of the player that is lynched during day 4). The claims that
# will be tested are the claims made during day 4.
condition = ANDCondition([VigilanteVeteranMafioso(5), SerialKillerKill(), DeathRole(14, Role.DOCTOR), VigilanteKill(),
    DeathRole(2, Role.DOCTOR), DeathRole(13, Role.MEDIUM), Witched(), ActualRole(7, Role.JAILOR), DeathRole(6, Role.BODYGUARD),
    ActualRole(5, Role.VIGILANTE), DeathRole(4, Role.BLACKMAILER), ActualRole(2, Role.DOCTOR), DeathRole(15, Role.GODFATHER),
    DoctorDisguiserSerialKiller(8), ActualRole(1, Role.WITCH), DeathRole(12, Role.DOCTOR), DeathRole(10, Role.BLACKMAILER),
    DeathRole(11, Role.GODFATHER)])

analyzer = Analyzer(GM.RANKED, 3, Role.INVESTIGATOR, condition)
analyzer.add_event("John Willard is Disguiser", ActualRole(14, Role.DISGUISER))
analyzer.add_event("noot claims Lookout", ActualRole(9, Role.LOOKOUT))
analyzer.add_event("LanaDelRay is Hostile", TownHostile(8))
analyzer.add_event("noot is Hostile", TownHostile(9))
analyzer.compute_likelihoods("After Night 4")