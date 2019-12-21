package townofsalemcalculator.Conditions.Concrete.KillMessages;

import townofsalemcalculator.Conditions.Abstract.InheritConditions.RoleExistenceCondition;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Conditions.SearchableCondition;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Kill Message appears at day time which shows how someone died
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-1
 */
public abstract class KillMessage implements SearchableCondition {
    private final Role role;
    
    public KillMessage(Role role) {
        this.role = role;
    }
    
    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup rg = new StandardInclude(new SingleRoleGroup(role), sr.amnesiacDetermine);
        Condition con = new RoleExistenceCondition(rg);
        con.useCondition(sr);
    }
}
