package townofsalemcalculator.Simulations;

import java.util.List;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.ConcreteConditions.ConcreteCondition;

/**
 * A Simulation will determine the likelihood of a condition based on Concrete Conditions which have happened
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-6
 */
public interface Simulation {
    /**
     * Check the likelihood of the check condition based on the hold conditions
     * @param check The condition of which the likelihood will be checked
     * @param holds The conditions which are known to hold
     * @return A double value between 0.0 and 1.0 that determines the likelihood. 1.0 means that the condition is very likely to be true, 
     * 0.0 means that the condition is not likely to be true.
     */
    public double doSimulation(AbstractCondition check, List<ConcreteCondition> holds);
}
