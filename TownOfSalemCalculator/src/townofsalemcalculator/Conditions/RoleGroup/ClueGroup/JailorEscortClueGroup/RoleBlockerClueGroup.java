package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.JailorEscortClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Escort;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group of a player that is able to roleblock anyone
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-24
 */
public class RoleBlockerClueGroup extends StandardInclude {
    
    public RoleBlockerClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new RoleBlockerInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class RoleBlockerInnerClueGroup extends CompositeRoleGroup {    
        public RoleBlockerInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Escort));
            addRoleGroup(new SingleRoleGroup(Consort));
        }
    }
}
