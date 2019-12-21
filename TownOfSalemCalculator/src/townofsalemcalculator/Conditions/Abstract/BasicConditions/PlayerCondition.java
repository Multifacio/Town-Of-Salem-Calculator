package townofsalemcalculator.Conditions.Abstract.BasicConditions;

import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * The condition that a player can have exactly 1 role
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-01
 */
public class PlayerCondition implements Condition {
    
    @Override
    public void useCondition(SimulationRun sr) {
        for (int i = 0; i < sr.playerRole.length; i++) {
            sr.model.sum(sr.playerRole[i], "=", 1).post(); 
        }
    }

}
