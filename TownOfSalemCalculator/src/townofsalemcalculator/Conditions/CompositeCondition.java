package townofsalemcalculator.Conditions;

import java.util.ArrayList;
import java.util.List;

/**
 * A Composite Condition are multiple Conditions included in one Condition
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class CompositeCondition implements Condition {
    private List<Condition> conditions; //The Condition that are included in this Composite Condition
    
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
}
