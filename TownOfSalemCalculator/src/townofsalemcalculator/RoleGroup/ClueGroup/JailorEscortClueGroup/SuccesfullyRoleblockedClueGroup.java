package townofsalemcalculator.RoleGroup.ClueGroup.JailorEscortClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.SerialKiller;
import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of a player that can be roleblocked without killing you (so only the Serial Killer gets excluded)
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-23
 */
public class SuccesfullyRoleblockedClueGroup extends StandardInclude {
    
    public SuccesfullyRoleblockedClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new SuccesfullyRoleblockedInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class SuccesfullyRoleblockedInnerClueGroup extends DifferenceRoleGroup {    
        public SuccesfullyRoleblockedInnerClueGroup() {
            super(new AllRoles(), new SingleRoleGroup(SerialKiller));
        }
    }
}
