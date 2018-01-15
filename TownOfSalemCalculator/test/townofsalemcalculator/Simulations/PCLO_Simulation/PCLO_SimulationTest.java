package townofsalemcalculator.Simulations.PCLO_Simulation;

import townofsalemcalculator.AbstractConditions.AdvancedConditions.MinimumRoleAmount;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.RoleKnownOfPlayer;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.GameCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.EitherRoleForRoleSelecter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import townofsalemcalculator.AbstractConditions.GameModusConditions.RankedPracticeGameModus;
import townofsalemcalculator.Game.Player;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.IncludingDisguiser;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.GameModusConditions.OldRankedPracticeGameModus;
import townofsalemcalculator.RoleGroup.ClueGroup.TownFriendlyNonCoven;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The PCLO Simulation Test
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public class PCLO_SimulationTest {
    private final List<Player> players; //The list of all Players participating in a game
    private final List<StartCategory> startCategories; //The list of all Start Categories in a game
    private static final double TOP_PRIORITY = 10000.0; //The priority of a prioritized claim that must always be true
    
    public PCLO_SimulationTest() {
        //Add the Player and Start Categories
        int index = 0;
        players = new ArrayList();
        startCategories = new ArrayList();
        for(int i = 0; i < 15; i++) {
            players.add(new Player(index, "", i));
            index++;
        }
        for(int i = 0; i < 15; i++) {
            startCategories.add(new StartCategory(index));
            index++;
        }
    }
    
    /**
     * An Impossible Claim, because already 4 Town Support roles are known. So a fifth claim is impossible
     */
    @Test
    public void testImpossibleTownSupportClaim() {       
        PCLO_Simulation sim = new PCLO_Simulation(players, startCategories);
        List<PrioritizedCondition> holds = new ArrayList();
        holds.add(new PrioritizedCondition(new GameCondition(players, startCategories), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RankedPracticeGameModus(startCategories), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(5), Mayor), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Transporter, 1), 10000.0));
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(8), new IncludingDisguiser(new SingleRoleGroup(Escort))), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(9), new IncludingDisguiser(new SingleRoleGroup(Medium))), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Janitor, 1), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Blackmailer, 1), TOP_PRIORITY));
        
        AbstractCondition check = new RoleKnownOfPlayer(players.get(3), Medium);
        double likelihood = sim.doSimulationWithPrioritizedConditions(check, holds);
        assertTrue("Impossible Town Support claim failed", likelihood == 0.0);
    }
    
    /**
     * This is a possible game, which can be seen in: https://www.youtube.com/watch?v=e5PTeCrE4X0
     */
    @Test
    public void testPossibleGame() {
        PCLO_Simulation sim = new PCLO_Simulation(players, startCategories);
        List<PrioritizedCondition> holds = new ArrayList();
        holds.add(new PrioritizedCondition(new GameCondition(players, startCategories), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RankedPracticeGameModus(startCategories), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(0), Bodyguard), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(1), Witch), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(2), Mafioso), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(3), Consort), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(4), Mayor), TOP_PRIORITY));
        
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(5), Sheriff), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(6), Werewolf), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(7), Consigliere), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(8), Godfather), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(9), Investigator), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(10), Escort), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(11), Jailor), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(12), Escort), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(13), Spy), TOP_PRIORITY));
        
        AbstractCondition check = new RoleKnownOfPlayer(players.get(14), Vigilante);
        double claimLikelihood = sim.doSimulationWithPrioritizedConditions(check, holds);
        double holdsLikelihood = sim.holdsLikelihood();
        assertTrue("Possible claim failed", claimLikelihood == 1.0 && holdsLikelihood == 0.0);
    }
    
    /**
     * Test the speed of the PCLO simulation. This game can be seen in https://www.youtube.com/watch?v=XvB5XTiHkSo
     */
    @Test
    public void testSpeed() {
        PCLO_Simulation sim = new PCLO_Simulation(players, startCategories);
        List<PrioritizedCondition> holds = new ArrayList();
        CompositeRoleGroup firstInvestResult = new CompositeRoleGroup();
        firstInvestResult.addRoleGroup(new SingleRoleGroup(Doctor));
        firstInvestResult.addRoleGroup(new SingleRoleGroup(Disguiser));
        firstInvestResult.addRoleGroup(new SingleRoleGroup(SerialKiller));
        CompositeRoleGroup secondInvestResult = new CompositeRoleGroup();
        secondInvestResult.addRoleGroup(new SingleRoleGroup(Spy));
        secondInvestResult.addRoleGroup(new SingleRoleGroup(Blackmailer));
        secondInvestResult.addRoleGroup(new SingleRoleGroup(Jailor));
        
        holds.add(new PrioritizedCondition(new GameCondition(players, startCategories), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new OldRankedPracticeGameModus(startCategories), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(1), Investigator), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(0), firstInvestResult), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, SerialKiller, 1), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(12), Retributionist), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(14), Medium), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(5), secondInvestResult), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(5), Jailor), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(9), Survivor), TOP_PRIORITY));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Vigilante, 1), TOP_PRIORITY));
        
        
        AbstractCondition check = new EitherRoleForRoleSelecter(players.get(0), new TownFriendlyNonCoven());
        long startTime = System.currentTimeMillis(); //Start with measuring the time
        sim.doSimulationWithPrioritizedConditions(check, holds);
        long totalTime = System.currentTimeMillis() - startTime; //Get the total running time of the simulation
        System.out.println("Script has runned: " + totalTime + " ms");
    }
}
