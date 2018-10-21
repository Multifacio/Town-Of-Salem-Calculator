package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.InvestigatorClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group for which the Investigator sees that it is a Survivor, Vampire Hunter or Amnesiac
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-20
 */
public class InvestigatorClueSurvivorVampireHunterAmnesiac extends FullInclude {
    
    public InvestigatorClueSurvivorVampireHunterAmnesiac(Set<Role> amnesiacTurnedInto) {
        super(new InvestigatorInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class InvestigatorInnerClueGroup extends CompositeRoleGroup {    
        public InvestigatorInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Survivor));
            addRoleGroup(new SingleRoleGroup(VampireHunter));
            addRoleGroup(new SingleRoleGroup(Amnesiac));
        }
    }
}
