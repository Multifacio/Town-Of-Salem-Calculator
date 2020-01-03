from src.Concepts.Rolegroup import Rolegroup as RG
from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Concrete.ActualRoleGroup import ActualRoleGroup
from src.Conditions.Concrete.KillTypes.VigilanteKill import VigilanteKill
from src.Conditions.Concrete.Lookout.OtherSingleVisitHarmless import OtherSingleVisitHarmless
from src.Conditions.Concrete.Others.NonKillRoleblock import NonKillRoleblock
from src.Conditions.Concrete.RoleKnown.ActualRole import ActualRole
from src.Conditions.Concrete.RoleKnown.DeathRole import DeathRole
from src.Conditions.Concrete.RoleKnown.StartRole import StartRole
from src.Conditions.Concrete.Sheriff.NotSuspicious import NotSuspicious
from src.Conditions.Concrete.TownHostile import TownHostile
from src.Mechanics.Analyzer import Analyzer
from src.Concepts.Gamemodus import Gamemodus as GM

# Likelihood After Night 6, so only the event during night 6 are used as evidence (which includes the players that
# died during this night, but does not include the role of the player that is lynched during day 6). The claims that
# will be tested are the claims made during day 6.

condition = ANDCondition([DeathRole(1, Role.MEDIUM), OtherSingleVisitHarmless(3, 7, False), ActualRole(9, Role.SHERIFF),
    StartRole(14, Role.GODFATHER), NotSuspicious(8, False), NotSuspicious(3, True), OtherSingleVisitHarmless(2, 10, True),
    ActualRole(7, Role.CONSORT), ActualRole(11, Role.JAILOR), NonKillRoleblock(4, False), NonKillRoleblock(5, False),
    DeathRole(13, Role.GODFATHER), ActualRole(5, Role.SHERIFF), NotSuspicious(12, False), DeathRole(6, Role.MAFIOSO),
    VigilanteKill(), ActualRole(12, Role.BODYGUARD)])

analyzer = Analyzer(GM.NEW_RANKED_PRACTICE, 15, Role.LOOKOUT, condition)
analyzer.add_event("Ramba claims Spy", ActualRole(3, Role.SPY))
analyzer.add_event("Red claims Sheriff", ActualRole(8, Role.SHERIFF))
analyzer.add_event("Red is Jester", ActualRole(8, Role.JESTER))
analyzer.add_event("3 Sheriff Claims", ANDCondition([ActualRole(5, Role.SHERIFF), ActualRole(8, Role.SHERIFF),
                                                     ActualRole(9, Role.SHERIFF)]))
analyzer.add_event("3 Sheriff + Spy Claim", ANDCondition([ActualRole(3, Role.SPY), ActualRole(5, Role.SHERIFF),
                                                        ActualRole(8, Role.SHERIFF), ActualRole(9, Role.SHERIFF)]))
analyzer.add_event("Zero claims Lookout to Jailor", ActualRole(4, Role.LOOKOUT))
analyzer.add_event("3 Sheriff + Spy + Lookout Claim ", ANDCondition([ActualRole(3, Role.SPY), ActualRole(5, Role.SHERIFF),
                                ActualRole(8, Role.SHERIFF), ActualRole(9, Role.SHERIFF), ActualRole(4, Role.LOOKOUT)]))
analyzer.add_event("Mayonaise claims Bodyguard", ActualRole(10, Role.BODYGUARD))
analyzer.add_event("Thomas Danforth claims Town Killing", ActualRoleGroup(2, RG.NC_TOWN_KILLING))
analyzer.add_event("Thomas Danforth is Hostile", TownHostile(2))
analyzer.add_event("Ramba is Hostile", TownHostile(3))
analyzer.add_event("Zero is Hostile", TownHostile(4))
analyzer.add_event("red is Hostile", TownHostile(8))
analyzer.add_event("mayonnaise is Hostile", TownHostile(10))
analyzer.compute_likelihoods("After Night 6")