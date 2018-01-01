package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import townofsalemcalculator.Conditions.*;
import java.util.ArrayList;
import java.util.List;
import scpsolver.problems.LPWizard;
import townofsalemcalculator.Counter;

public class PCLO_Condition_CompositeCondition implements PCLO_ConditionImplementation {
    private List<Condition> conditions; //The Conditions that are included in the PCLO implementation of the Composite Condition
    
    /**
     * @param conditions The Conditions that are included in the PCLO implementation of the Composite Condition
     */
    public PCLO_Condition_CompositeCondition(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        //Do the addHoldCondition for all conditions in the Composite Condition
        for (Condition c : conditions) {
            c.getPCLO_Implementation().addHoldCondition(lpw, counter, conditionNumber);
        }
    }

    @Override
    public void setCheckCondition(LPWizard lpw, Counter counter) {
        //Do the setCheckCondition for all conditions in the Composite Condition
        for (Condition c : conditions) {
            c.getPCLO_Implementation().setCheckCondition(lpw, counter);
        }
    }
}
