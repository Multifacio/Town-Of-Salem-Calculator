package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.SheriffClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.AllRoles;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup.SheriffSuspiciousNonFullMoon;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;

/**
 * The role group of the player for which the Sheriff gets the message that he is not suspicious which happens not during Full Moon
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-19
 */
public class SheriffNotSuspiciousNonFullMoonClueGroup extends StandardInclude {
    
    public SheriffNotSuspiciousNonFullMoonClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new SheriffSuspiciousNonFullMoonClueGroupInner(), amnesiacTurnedInto);
    }  
    
    static class SheriffSuspiciousNonFullMoonClueGroupInner extends DifferenceRoleGroup {    
        public SheriffSuspiciousNonFullMoonClueGroupInner() {
            super(new AllRoles(), new SheriffSuspiciousNonFullMoon());
        }
    }
}
