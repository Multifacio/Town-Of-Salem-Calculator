from src.Concepts.Rolegroup import Rolegroup as RG
from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Concrete.ActualRoleGroup import ActualRoleGroup
from src.Conditions.Concrete.Effects.Witched import Witched
from src.Conditions.Concrete.Investigator.VigilanteVeteranMafioso import VigilanteVeteranMafioso
from src.Conditions.Concrete.KillTypes.SerialKillerKill import SerialKillerKill
from src.Conditions.Concrete.KillTypes.VigilanteKill import VigilanteKill
from src.Conditions.Concrete.RoleKnown.ActualRole import ActualRole
from src.Conditions.Concrete.RoleKnown.DeathRole import DeathRole
from src.Conditions.Concrete.TownHostile import TownHostile
from src.Mechanics.Analyzer import Analyzer
from src.Concepts.Gamemodus import Gamemodus as GM

# Likelihood After Night 2, so only the event during night 2 are used as evidence (which includes the players that
# died during this night, but does not include the role of the player that is lynched during day 2). The claims that
# will be tested are the claims made during day 2.

# Pretty is confirmed Doctor, because the Vigilante died shooting him.
condition = ANDCondition([VigilanteVeteranMafioso(5), SerialKillerKill(), DeathRole(14, Role.DOCTOR), VigilanteKill(),
    DeathRole(2, Role.DOCTOR), DeathRole(13, Role.MEDIUM), Witched(), ActualRole(7, Role.JAILOR), DeathRole(6, Role.BODYGUARD),
    ActualRole(5, Role.VIGILANTE), DeathRole(4, Role.BLACKMAILER), ActualRole(2, Role.DOCTOR)])

analyzer = Analyzer(GM.RANKED, 3, Role.INVESTIGATOR, condition)
analyzer.add_event("He claims Bodyguard", ActualRole(15, Role.BODYGUARD))
analyzer.add_event("Town claims Doctor", ActualRole(12, Role.DOCTOR))
analyzer.add_event("John Willard is Disguiser", ActualRole(14, Role.DISGUISER))
analyzer.add_event("Town is Serial Killer", ActualRole(12, Role.SERIALKILLER))
analyzer.add_event("noot claims Lookout", ActualRole(9, Role.LOOKOUT))
analyzer.add_event("2 Bodyguard + Doctor claim", ANDCondition([ActualRole(6, Role.BODYGUARD), ActualRole(12, Role.DOCTOR),
                                                               ActualRole(15, Role.BODYGUARD)]))
analyzer.add_event("Crops is Hostile", TownHostile(1))
analyzer.add_event("LanaDelRay is Hostile", TownHostile(8))
analyzer.add_event("noot is Hostile", TownHostile(9))
analyzer.add_event("Afk is Hostile", TownHostile(10))
analyzer.add_event("Ocean Man is Hostile", TownHostile(11))
analyzer.add_event("Town is Hostile", TownHostile(12))
analyzer.add_event("He is Hostile", TownHostile(15))
analyzer.compute_likelihoods("After Night 2")