package townofsalemcalculator.AbstractConditions;

import java.util.ArrayList;
import java.util.List;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_ConditionImplementation;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_Condition_CompositeCondition;

/**
 * A Composite AbstractCondition are multiple Conditions included in one AbstractCondition
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class CompositeCondition implements AbstractCondition {
    private List<AbstractCondition> conditions; //The AbstractCondition that are included in this Composite AbstractCondition
    
    /**
     * Create a Composite AbstractCondition consisting of no Conditions
     */
    public CompositeCondition() {
        conditions = new ArrayList();
    }
    
    /**
     * Adds a AbstractCondition to the Composite AbstractCondition
     * @param condition The AbstractCondition that will be included in this Composite AbstractCondition
     */
    public void addCondition(AbstractCondition condition) {
        conditions.add(condition);
    }

    @Override
    public PCLO_ConditionImplementation getPCLO_Implementation() {
        return new PCLO_Condition_CompositeCondition(conditions);
    }
}
