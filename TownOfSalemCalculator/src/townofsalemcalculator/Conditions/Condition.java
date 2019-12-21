package townofsalemcalculator.Conditions;

import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Condition is a statement about the game which is true
 * @author Multifacio
 * @version 1.1
 * @since 2017-01-05
 */
public interface Condition {
    /**
     * Use a condition in the Simulation
     * @param sr The simulation run instance in which this condition is added
     */
    public void useCondition(SimulationRun sr);
}
