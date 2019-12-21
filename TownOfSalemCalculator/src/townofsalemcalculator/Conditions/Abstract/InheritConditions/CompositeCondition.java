package townofsalemcalculator.Conditions.Abstract.InheritConditions;

import java.util.ArrayList;
import java.util.List;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Composite Condition are multiple Conditions included in one Condition
 * @author Multifacio
 * @version 1.1
 * @since 2017-12-30
 */
public class CompositeCondition implements Condition {
    private List<Condition> conditions; //The Conditions that are included in this Composite Condition
    
    /**
     * Create a Composite Condition consisting of no Conditions
     */
    public CompositeCondition() {
        conditions = new ArrayList();
    }
    
    /**
     * Adds a Condition to the Composite Condition
     * @param condition The Condition that will be included in this Composite Condition
     */
    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    @Override
    public void useCondition(SimulationRun sr) {
        for (Condition c : conditions) {
            c.useCondition(sr);
        }
    }
}
