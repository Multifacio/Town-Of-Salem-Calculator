package townofsalemcalculator.RoleGroup.ClueGroup.IndirectClueGroup;

import static townofsalemcalculator.Role.Werewolf;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of all players that don't get a message of being not suspicious during a Full Moon night
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-19
 */
public class SheriffSuspiciousFullMoon extends CompositeRoleGroup {
    
    public SheriffSuspiciousFullMoon() {
        addRoleGroup(new SheriffSuspiciousNonFullMoon());
        addRoleGroup(new SingleRoleGroup(Werewolf));
    }  
}
