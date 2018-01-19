package townofsalemcalculator.RoleGroup.ClueGroup.SheriffClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.SerialKiller;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of the player for which the Sheriff gets the message that he is Serial Killer 
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-17
 */
public class SheriffSerialKillerClueGroup extends StandardInclude {
    
    public SheriffSerialKillerClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new SingleRoleGroup(SerialKiller), amnesiacTurnedInto);
    }
}
