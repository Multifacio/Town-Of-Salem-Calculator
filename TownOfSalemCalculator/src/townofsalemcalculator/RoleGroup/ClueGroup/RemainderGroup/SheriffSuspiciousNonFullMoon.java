package townofsalemcalculator.RoleGroup.ClueGroup.RemainderGroup;

import static townofsalemcalculator.Role.SerialKiller;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of all players that don't get a message of being not suspicious during a non Full Moon night
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-19
 */
public class SheriffSuspiciousNonFullMoon extends CompositeRoleGroup {
    
    public SheriffSuspiciousNonFullMoon() {
        addRoleGroup(new MafiaExceptGodfather());
        addRoleGroup(new SingleRoleGroup(SerialKiller));
    }  
}
