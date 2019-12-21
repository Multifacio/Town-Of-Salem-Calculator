package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;

/**
 * Include the standard roles that can become a role
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-18
 */
public class StandardInclude extends IncludingAmnesiac {
    /**
     * Create a Standard Include group
     * @param roleGroup The Role Group which is included in this Role Group
     * @param amnesiacTurnedInto The set of all roles in which an Amnesiac has turned into
     */
    public StandardInclude(RoleGroup roleGroup, Set<Role> amnesiacTurnedInto) {
        super(new StandardIncludeInner(roleGroup), amnesiacTurnedInto);
    }
    
    static class StandardIncludeInner extends IncludingBecomeRoles {
        public StandardIncludeInner(RoleGroup roleGroup) {
            super(roleGroup);
        }
    }
}
