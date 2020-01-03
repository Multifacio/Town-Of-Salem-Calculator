from src.Concepts.Rolegroup import Rolegroup as RG
from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Concrete.ActualRoleGroup import ActualRoleGroup
from src.Conditions.Concrete.Lookout.OtherSingleVisitHarmless import OtherSingleVisitHarmless
from src.Conditions.Concrete.RoleKnown.ActualRole import ActualRole
from src.Conditions.Concrete.RoleKnown.DeathRole import DeathRole
from src.Conditions.Concrete.RoleKnown.StartRole import StartRole
from src.Conditions.Concrete.Sheriff.NotSuspicious import NotSuspicious
from src.Conditions.Concrete.TownHostile import TownHostile
from src.Mechanics.Analyzer import Analyzer
from src.Concepts.Gamemodus import Gamemodus as GM

# Likelihood After Night 3, so only the event during night 3 are used as evidence (which includes the players that
# died during this night, but does not include the role of the player that is lynched during day 3). The claims that
# will be tested are the claims made during day 3.

# We assumed that 9 really was Sheriff in the evidence and that his will is correct.
condition = ANDCondition([DeathRole(1, Role.MEDIUM), OtherSingleVisitHarmless(3, 7, False), ActualRole(9, Role.SHERIFF),
                          StartRole(14, Role.GODFATHER), NotSuspicious(8, False), NotSuspicious(3, True)])

analyzer = Analyzer(GM.NEW_RANKED_PRACTICE, 15, Role.LOOKOUT, condition)
analyzer.add_event("Ramba claims Spy", ActualRole(3, Role.SPY))
analyzer.add_event("Harold Pooter claims Sheriff", ActualRole(5, Role.SHERIFF))
analyzer.add_event("Harold Pooter is Executioner", ActualRole(5, Role.EXECUTIONER))
analyzer.add_event("Harold Pooter is Jester", ActualRole(5, Role.JESTER))
analyzer.add_event("Red claims Sheriff", ActualRole(8, Role.SHERIFF))
analyzer.add_event("Red is Jester", ActualRole(8, Role.JESTER))
analyzer.add_event("Vsus claims Escort", ActualRole(13, Role.ESCORT))
analyzer.add_event("Vsus is Mafia", ActualRoleGroup(13, RG.NC_MAFIA))
analyzer.add_event("3 Sheriff Claims", ANDCondition([ActualRole(5, Role.SHERIFF), ActualRole(8, Role.SHERIFF),
                                                     ActualRole(9, Role.SHERIFF)]))
analyzer.add_event("3 Sheriff + Spy Claim", ANDCondition([ActualRole(3, Role.SPY), ActualRole(5, Role.SHERIFF),
                                                        ActualRole(8, Role.SHERIFF), ActualRole(9, Role.SHERIFF)]))
analyzer.add_event("Thomas Danforth is Hostile", TownHostile(2))
analyzer.add_event("Ramba is Hostile", TownHostile(3))
analyzer.add_event("Zero is Hostile", TownHostile(4))
analyzer.add_event("Harold Pooter is Hostile", TownHostile(5))
analyzer.add_event("A Lesbian is Hostile", TownHostile(6))
analyzer.add_event("succ is Hostile", TownHostile(7))
analyzer.add_event("red is Hostile", TownHostile(8))
analyzer.add_event("mayonnaise is Hostile", TownHostile(10))
analyzer.add_event("Sean Cody is Hostile", TownHostile(11))
analyzer.add_event("fate is Hostile", TownHostile(12))
analyzer.add_event("Vsus is Hostile", TownHostile(13))
analyzer.compute_likelihoods("After Night 3")