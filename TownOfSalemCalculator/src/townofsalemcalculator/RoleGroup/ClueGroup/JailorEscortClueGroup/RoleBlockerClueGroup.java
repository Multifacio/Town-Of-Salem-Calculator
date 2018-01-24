package townofsalemcalculator.RoleGroup.ClueGroup.JailorEscortClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Escort;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of a player that is able to roleblock anyone
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-24
 */
public class RoleBlockerClueGroup extends FullInclude {
    
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
