package townofsalemcalculator.RoleGroup.ClueGroup.JailorEscortClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Jailor;
import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of players that can be jailed (so everyone except the Jailor)
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-24
 */
public class InJailClueGroup extends StandardInclude {
    
    public InJailClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new InJailInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class InJailInnerClueGroup extends DifferenceRoleGroup {    
        public InJailInnerClueGroup() {
            super(new AllRoles(), new SingleRoleGroup(Jailor));
        }
    }
}
