package townofsalemcalculator.Simulations.PCLO_Simulation;

import scpsolver.problems.LPWizard;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Counter;

/**
 * A Prioritized Condition is a condition with a priority value, which determines the likelihood that the condition is true.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-31
 */
public class PrioritizedCondition {
    private final Condition condition; //The condition that belongs to the Prioritized Condition
    private final double priority; //The priority value of the Prioritized Condition. Must be larger than 0, the larger this value the more likely this condition is true.
    
    /**
     * Create a Prioritized Condition
     * @param condition The condition that belongs to the Prioritized Condition
     * @param priority The priority value of the Prioritized Condition. Must be larger than 0, the larger this value the more likely this condition is true.
     */
    public PrioritizedCondition(Condition condition, double priority) {
        this.condition = condition;
        this.priority = priority;
    }
    
    /**
     * Get the condition that belongs to this Prioritized Condition
     * @return The condition of this Prioritized Condition
     */
    public Condition getCondition() {
        return condition;
    }
    
    /**
     * Get the priority value of this Prioritized Condition
     * @return The priority value of this Prioritized Condition
     */
    public double getPriority() {
        return priority;
    }
    
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        lpw.plus("Constraint" + counter.getCounterValue(), priority);
        condition.getPCLO_Implementation().addHoldCondition(lpw, counter, conditionNumber);
    }
}
