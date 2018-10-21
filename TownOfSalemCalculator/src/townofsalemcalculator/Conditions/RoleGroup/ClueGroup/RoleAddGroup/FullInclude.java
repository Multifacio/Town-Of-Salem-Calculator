package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;

/**
 * Include the standard roles that can become a role and include the Disguiser
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-20
 */
public class FullInclude extends IncludingDisguiser {
    
    public FullInclude(RoleGroup roleGroup, Set<Role> amnesiacTurnedInto) {
        super(new FullIncludeInner(roleGroup, amnesiacTurnedInto));
    }
    
    static class FullIncludeInner extends StandardInclude {
        public FullIncludeInner(RoleGroup roleGroup, Set<Role> amnesiacTurnedInto) {
            super(roleGroup, amnesiacTurnedInto);
        }
    }
}
