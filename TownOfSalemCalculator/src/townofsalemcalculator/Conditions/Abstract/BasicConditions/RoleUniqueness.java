package townofsalemcalculator.Conditions.Abstract.BasicConditions;

import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * The condition that a role must be unique (so at most 1 of this role). For example there cannot be 2 Veterans in the same game.
 * @author Multifacio
 * @version 1.1
 * @since 2017-12-30
 */
public class RoleUniqueness implements Condition {
    private final Role role; //The role that is unique
    
    /**
     * Create a Role Uniqueness condition
     * @param role The role which must be unique
     */
    public RoleUniqueness(Role role) {
        this.role = role;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        int roleNum = role.ordinal();
        BoolVar[] vars = new BoolVar[sr.startCategoryRole.length];
        for (int i = 0; i < sr.startCategoryRole.length; i++) {
            vars[i] = sr.startCategoryRole[i][roleNum];
        }
        sr.model.sum(vars, "<=", 1);
    }
}
