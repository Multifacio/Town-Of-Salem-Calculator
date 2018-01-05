package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import townofsalemcalculator.AbstractConditions.AbstractCondition;
import java.util.ArrayList;
import java.util.List;
import scpsolver.problems.LPWizard;
import townofsalemcalculator.Counter;

public class PCLO_Condition_CompositeCondition implements PCLO_ConditionImplementation {
    private List<AbstractCondition> conditions; //The Conditions that are included in the PCLO implementation of the Composite AbstractCondition
    
    /**
     * @param conditions The Conditions that are included in the PCLO implementation of the Composite AbstractCondition
     */
    public PCLO_Condition_CompositeCondition(List<AbstractCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        //Do the addHoldCondition for all conditions in the Composite AbstractCondition
        for (AbstractCondition c : conditions) {
            c.getPCLO_Implementation().addHoldCondition(lpw, counter, conditionNumber);
        }
    }

    @Override
    public void setCheckCondition(LPWizard lpw, Counter counter) {
        //Do the setCheckCondition for all conditions in the Composite AbstractCondition
        for (AbstractCondition c : conditions) {
            c.getPCLO_Implementation().setCheckCondition(lpw, counter);
        }
    }
}
