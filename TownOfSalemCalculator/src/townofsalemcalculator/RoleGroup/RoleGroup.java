package townofsalemcalculator.RoleGroup;

import java.util.Set;
import townofsalemcalculator.Role;

/**
 * A Role Group is a set of multiple roles.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public interface RoleGroup {
    /**
     * Get the roles of the Role Group
     * @return The set of roles in the Role Group
     */
    public Set<Role> getRoles();
}
