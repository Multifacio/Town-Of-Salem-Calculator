package townofsalemcalculator.Simulations.PCLO_Simulation;

import scpsolver.problems.LPWizard;
import townofsalemcalculator.Counter;
import townofsalemcalculator.AbstractConditions.AbstractCondition;

/**
 * A Prioritized AbstractCondition is a condition with a priority value, which determines the likelihood that the condition is true.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-31
 */
public class PrioritizedCondition {
    private final AbstractCondition condition; //The condition that belongs to the Prioritized AbstractCondition
    private final double priority; //The priority value of the Prioritized AbstractCondition. Must be larger than 0, the larger this value the more likely this condition is true.
    
    /**
     * Create a Prioritized AbstractCondition
     * @param condition The condition that belongs to the Prioritized AbstractCondition
     * @param priority The priority value of the Prioritized AbstractCondition. Must be larger than 0, the larger this value the more likely this condition is true.
     */
    public PrioritizedCondition(AbstractCondition condition, double priority) {
        this.condition = condition;
        this.priority = priority;
    }
    
    /**
     * Get the condition that belongs to this Prioritized AbstractCondition
     * @return The condition of this Prioritized AbstractCondition
     */
    public AbstractCondition getCondition() {
        return condition;
    }
    
    /**
     * Get the priority value of this Prioritized AbstractCondition
     * @return The priority value of this Prioritized AbstractCondition
     */
    public double getPriority() {
        return priority;
    }
    
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        lpw.plus("Condition" + conditionNumber, priority);
        condition.getPCLO_Implementation().addHoldCondition(lpw, counter, conditionNumber);
    }
}
