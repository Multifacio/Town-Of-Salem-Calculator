package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Set;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupOrRoleExistenceCondition;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.RoleExistenceCondition;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Conditions.SearchableCondition;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * An Investigator Clue condition (which are messages the investigator receives about a person)
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-28
 */
public abstract class InvestigatorClue implements SearchableCondition {
    private final Player player;
    private final RoleGroup roleGroup;
    
    public InvestigatorClue(Player player, RoleGroup roleGroup) {
        this.player = player;
        this.roleGroup = roleGroup;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup rg = new InvestigatorClueGroup(roleGroup, sr.amnesiacDetermine);
        Condition con = new PlayerIsRoleGroupOrRoleExistenceCondition(player, rg, new StandardInclude(new SingleRoleGroup(Transporter), sr.amnesiacDetermine));
        con.useCondition(sr);
        Condition con2 = new RoleExistenceCondition(rg);
        con2.useCondition(sr);
    }
    
    static class InvestigatorClueGroup extends FullInclude { 
        public InvestigatorClueGroup(RoleGroup roleGroup, Set<Role> amnesiacTurnedInto) {
            super(roleGroup, amnesiacTurnedInto);
        } 
    }    
}
