package townofsalemcalculator.Conditions.Concrete.NightMessages;

import townofsalemcalculator.Conditions.Abstract.InheritConditions.RoleExistenceCondition;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.SearchableCondition;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * Night Messages are messages that anyone can receive during the night
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-01
 */
public abstract class NightMessage implements SearchableCondition {
    private final RoleGroup roleGroup;
    
    public NightMessage(RoleGroup roleGroup) {
        this.roleGroup = roleGroup;
    }
    
    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup rg = new StandardInclude(roleGroup, sr.amnesiacDetermine);
        Condition con = new RoleExistenceCondition(rg);
        con.useCondition(sr);
    }
}
