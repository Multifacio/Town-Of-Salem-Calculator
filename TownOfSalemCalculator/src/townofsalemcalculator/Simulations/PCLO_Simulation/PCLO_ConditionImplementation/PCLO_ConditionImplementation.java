package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

/**
 * Used to implement a condition in the PCLO Simulation
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-31
 */
public interface PCLO_ConditionImplementation {
    /**
     * Add a condition which must hold in the PCLO Simulation
     * @param conditionNumber The index of the condition in the Prioritized Condition list
     */
    public void addHoldCondition(int conditionNumber);
    
    /**
     * Set a condition which will be checked whether it is true or not
     */
    public void setCheckCondition();
}
