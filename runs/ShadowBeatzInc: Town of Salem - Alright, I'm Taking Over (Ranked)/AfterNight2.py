from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Concrete.Investigator.InvestigatorConsigliereMayor import InvestigatorConsigliereMayor
from src.Conditions.Concrete.Investigator.SpyBlackmailerJailor import SpyBlackmailerJailor
from src.Conditions.Concrete.KillTypes.Cleaned import Cleaned
from src.Conditions.Concrete.KillTypes.SerialKillerKill import SerialKillerKill
from src.Conditions.Concrete.KillTypes.VeteranKill import VeteranKill
from src.Conditions.Concrete.Lookout.OtherVisit import OtherVisit
from src.Conditions.Concrete.Others.MafiaVisit import MafiaVisit
from src.Conditions.Concrete.RoleKnown.ActualRole import ActualRole
from src.Conditions.Concrete.RoleKnown.DeathRole import DeathRole
from src.Conditions.Concrete.Sheriff.NotSuspicious import NotSuspicious
from src.Conditions.Concrete.Sheriff.Suspicious import Suspicious
from src.Conditions.Concrete.TownHostile import TownHostile
from src.Mechanics.Analyzer import Analyzer
from src.Concepts.Gamemodus import Gamemodus as GM

# Likelihood After Night 2, so only the event during night 2 are used as evidence (which includes the players that
# died during this night, but does not include the role of the player that is lynched during day 2). The claims that
# will be tested are the claims made during day 2.

# James Bayley claim to be Jailor is false, because James Bayles is executed by Jailor. Lauren claims Jailor instead
# which we believe otherwise Lauren gets executed.
condition = ANDCondition([ActualRole(4, Role.JAILOR), NotSuspicious(4, False), SerialKillerKill(), DeathRole(10, Role.CONSORT),
    Cleaned(), MafiaVisit(14), DeathRole(13, Role.RETRIBUTIONIST), Suspicious(2, True), ActualRole(3, Role.SERIALKILLER),
    VeteranKill(), MafiaVisit(1), OtherVisit(1, True)])

analyzer = Analyzer(GM.RANKED, 12, Role.SHERIFF, condition)
analyzer.add_event("James Russel claims Sheriff", ActualRole(15, Role.SHERIFF))
analyzer.add_event("Trustworthy Guy claims Bodyguard", ActualRole(6, Role.BODYGUARD))
analyzer.add_event("wmwmwmwmwmwmwmwm claims Investigator", ActualRole(8, Role.INVESTIGATOR))
analyzer.add_event("wmwmwmwmwmwmwmwm invest action N1 & N2 are true",
                   ANDCondition([InvestigatorConsigliereMayor(1), SpyBlackmailerJailor(4)]))
analyzer.add_event("James Russel, Light and wmwmwmwmwmwmwmwm are all Town Investigatives", ANDCondition([
    ActualRole(15, Role.SHERIFF), ActualRole(1, Role.INVESTIGATOR), ActualRole(8, Role.INVESTIGATOR)]))
analyzer.add_event("willy peener claims Vigilante", ActualRole(7, Role.VIGILANTE))
analyzer.add_event("Miles Morales is Hostile", TownHostile(2))
analyzer.add_event("Vet Bates is Hostile", TownHostile(5))
analyzer.add_event("Trustworthy Guy is Hostile", TownHostile(6))
analyzer.add_event("willy peener is Hostile", TownHostile(7))
analyzer.add_event("wmwmwmwmwmwmwmwm is Hostile", TownHostile(8))
analyzer.add_event("Pavilian is Hostile", TownHostile(9))
analyzer.add_event("shoot slivo is Hostile", TownHostile(11))
analyzer.add_event("James Russel is Hostile", TownHostile(15))
analyzer.compute_likelihoods("After Night 2")