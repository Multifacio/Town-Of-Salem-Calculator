package townofsalemcalculator.AbstractConditions;

import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_ConditionImplementation;

/**
 * A Abstract Condition is a statement about the game
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public interface AbstractCondition {
    /**
     * Get the PCLO implementation of the condition
     * @return The PCLO implementation of the condition
     */
    public PCLO_ConditionImplementation getPCLO_Implementation();
}
