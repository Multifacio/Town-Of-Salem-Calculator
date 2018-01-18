package townofsalemcalculator.RoleGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.Role;

/**
 * A Role Group consisting of multiple Role Groups
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class CompositeRoleGroup implements RoleGroup {
    private final List<RoleGroup> roleGroups; //The Role Groups that are included in this Composite Role Group
    
    /**
     * Create a Composite Role Group consisting of no Role Groups
     */
    public CompositeRoleGroup() {
        roleGroups = new ArrayList();
    }

    /**
     * Add a Role Group to the Composite Role Group
     * @param roleGroup The Role Group that will be included in this Composite Role Group.
     */
    public final void addRoleGroup(RoleGroup roleGroup) {
        roleGroups.add(roleGroup);
    }
    
    @Override
    public Set<Role> getRoles() {
        HashSet<Role> roles = new HashSet();
        for(RoleGroup rg : roleGroups) {
            roles.addAll(rg.getRoles()); //Add all roles of each Role Group that is included in this Composite Role Group
        }
        return roles;
    }
}
