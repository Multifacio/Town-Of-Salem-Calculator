package townofsalemcalculator.RoleGroup.ClueGroup.SheriffClueGroup;

import static townofsalemcalculator.Role.SerialKiller;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.BecomeRoles;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of the player for which the Sheriff gets the message that he is Serial Killer 
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-17
 */
public class SheriffSerialKillerClueGroup extends BecomeRoles {
    
    public SheriffSerialKillerClueGroup() {
        super(new SingleRoleGroup(SerialKiller));
    }
}
