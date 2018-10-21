package townofsalemcalculator.Conditions;

import townofsalemcalculator.Simulations.Simulation;

/**
 * A Condition is a statement about the game which is true
 * @author Multifacio
 * @version 1.1
 * @since 2017-01-05
 */
public interface Condition {
    /**
     * Use a condition in the simulation (the Simulation class will call this method)
     * @param s The simulation class in which this condition is added
     */
    public void useCondition(Simulation s);
}
