package townofsalemcalculator.Simulations.PCLO_Simulation;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import townofsalemcalculator.Conditions.AdvancedConditions.*;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.GameModusConditions.RankedPracticeGameModus;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.DeathRole;
import townofsalemcalculator.StartCategory;

/**
 * The PCLO Simulation Test
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public class PCLO_SimulationTest {
    private final List<Player> players; //The list of all Players participating in a game
    private final List<StartCategory> startCategories; //The list of all Start Categories in a game
    
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
    
    @Test
    public void testImpossibleTownSupportClaim() {       
        PCLO_Simulation sim = new PCLO_Simulation(players, startCategories);
        List<PrioritizedCondition> holds = new ArrayList();
        holds.add(new PrioritizedCondition(new GameCondition(players, startCategories), 100.0));
        holds.add(new PrioritizedCondition(new RankedPracticeGameModus(startCategories), 100.0));
        holds.add(new PrioritizedCondition(new RoleKnownOfPlayer(players.get(5), Mayor), 100.0));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Transporter, 1), 100.0));
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(8), new DeathRole(Escort)), 100.0));
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(9), new DeathRole(Medium)), 100.0));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Janitor, 1), 100.0));
        holds.add(new PrioritizedCondition(new MinimumRoleAmount(startCategories, Blackmailer, 1), 100.0));
        
        Condition check = new RoleKnownOfPlayer(players.get(3), Medium);
        int likelihood = sim.doSimulation(check, holds);
        assertTrue("Impossible Town Support claim failed", likelihood == 0);
    }
    
}
