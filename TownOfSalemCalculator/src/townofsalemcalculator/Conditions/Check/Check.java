package townofsalemcalculator.Conditions.Check;

import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A check is a statement about the game of which the likelihood is checked
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-22
 */
public interface Check {
    /**
     * Check whether the variables in the Simulation Run satisfy the statement
     * @param sr The simulation run
     * @return True when the variables satisfy the statement, false when it does not satisfy the statement
     */
    public boolean satisfies(SimulationRun sr);
}
