package townofsalemcalculator.Conditions.Abstract.BasicConditions;

import java.util.HashSet;
import java.util.Set;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * The condition that a start category is exactly 1 role and only a role inside the corresponding Role Group
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-31
 */
public class StartCategoryCondition implements Condition {
    private final RoleGroup[] startCategories;
    
    public StartCategoryCondition(RoleGroup[] startCategories) {
        this.startCategories = startCategories;
    }
    @Override
    public void useCondition(SimulationRun sr) {
        for (int i = 0; i < sr.startCategoryRole.length; i++) {
            sr.model.sum(sr.startCategoryRole[i], "=", 1).post(); //A start category is exactly 1 role
            Set<Integer> roleNums = new HashSet(); //A start category can only be of the corresponding role group
            for (Role r : startCategories[i].getRoles()) {
                roleNums.add(r.ordinal());
            }
            for (int j = 0; j < sr.startCategoryRole[i].length; j++) {
                if (!roleNums.contains(j)) {
                    sr.model.arithm(sr.startCategoryRole[i][j], "=", 0).post();
                }
            }
        }
    }

}
