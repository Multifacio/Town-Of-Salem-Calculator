package townofsalemcalculator.Simulations.PCLO_Simulation;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import townofsalemcalculator.Conditions.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Player;
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
    public void testWrongCheck() {       
        PCLO_Simulation sim = new PCLO_Simulation(players, startCategories);
        List<PrioritizedCondition> holds = new ArrayList();
        holds.add(new PrioritizedCondition(new EitherRoleForRoleSelecter(players.get(5), )));
    }
    
}
