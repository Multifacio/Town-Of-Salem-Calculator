package townofsalemcalculator.RoleGroup.ClueGroup.SheriffClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.RoleGroup.ClueGroup.IndirectClueGroup.SheriffSuspiciousFullMoon;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;

/**
 * The role group of the player for which the Sheriff gets the message that he is not suspicious which happens during Full Moon
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-19
 */
public class SheriffNotSuspiciousFullMoonClueGroup extends StandardInclude {
    
    public SheriffNotSuspiciousFullMoonClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new SheriffSuspiciousFullMoonClueGroupInner(), amnesiacTurnedInto);
    }  
    
    static class SheriffSuspiciousFullMoonClueGroupInner extends DifferenceRoleGroup { 
        public SheriffSuspiciousFullMoonClueGroupInner() {
            super(new AllRoles(), new SheriffSuspiciousFullMoon());
        }
    }
}
