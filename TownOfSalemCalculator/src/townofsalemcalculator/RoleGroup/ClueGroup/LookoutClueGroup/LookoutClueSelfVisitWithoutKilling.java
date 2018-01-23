package townofsalemcalculator.RoleGroup.ClueGroup.LookoutClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of a player that visited itself which is seen by the Lookout and the Lookout does not get attacked (so no Veteran or Werewolf visiting itself)
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-21
 */
public class LookoutClueSelfVisitWithoutKilling extends FullInclude {
    
    public LookoutClueSelfVisitWithoutKilling(Set<Role> amnesiacTurnedInto) {
        super(new LookoutInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class LookoutInnerClueGroup extends CompositeRoleGroup {    
        public LookoutInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Bodyguard));
            addRoleGroup(new SingleRoleGroup(Doctor));
            addRoleGroup(new SingleRoleGroup(Transporter));
            addRoleGroup(new SingleRoleGroup(Survivor));
            addRoleGroup(new SingleRoleGroup(Arsonist));
        }
    }
}
