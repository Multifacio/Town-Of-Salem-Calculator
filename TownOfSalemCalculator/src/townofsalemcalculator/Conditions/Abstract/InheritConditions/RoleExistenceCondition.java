package townofsalemcalculator.Conditions.Abstract.InheritConditions;

import java.util.Set;
import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Role Existence Condition is that a Role Group must occur at least once in the player list
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-22
 */
public class RoleExistenceCondition implements Condition {
    private final RoleGroup existRoleGroup;
    
    public RoleExistenceCondition(RoleGroup existRoleGroup) {
        this.existRoleGroup = existRoleGroup;
    }
    
    @Override
    public void useCondition(SimulationRun sr) {
        Set<Role> roles = existRoleGroup.getRoles();
        BoolVar[] vars = new BoolVar[sr.playerRole.length * roles.size()];
        int i = 0;
        for (int p = 0; p < sr.playerRole.length; p++) {
            for (Role r : roles) {
               int roleNum = r.ordinal();
               vars[i] = sr.playerRole[p][roleNum];
               i++; 
            }
        }
        sr.model.sum(vars, ">=", 1).post();
    }

}
