package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import scpsolver.problems.LPWizard;
import townofsalemcalculator.Counter;

/**
 * Used to implement a condition in the PCLO Simulation
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-31
 */
public interface PCLO_ConditionImplementation {
    /**
     * Add a condition which must hold in the PCLO Simulation
     * @param lpw The lineair problem
     * @param counter A counter used to give all constraints a different naming
     * @param conditionNumber The index of the condition in the Prioritized Condition list
     */
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber);
    
    /**
     * Set a condition which will be checked whether it is true or not
     * @param lpw The lineair problem
     * @param counter A counter used to give all constraints a different naming
     */
    public void setCheckCondition(LPWizard lpw, Counter counter);
}
