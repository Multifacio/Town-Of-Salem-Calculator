package townofsalemcalculator.Conditions.RoleGroup;

import java.util.Set;
import townofsalemcalculator.Role;

/**
 * A Difference Role Group is a Role Group without the roles of another Role Group
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-6
 */
public class DifferenceRoleGroup implements RoleGroup {
    private final RoleGroup includingGroup; //The Role Group of which the excludingGroup will be substracted
    private final RoleGroup excludingGroup; //The Roles of this group will be substracted from the including Role Group
    
    /**
     * Create a Difference Role Group
     * @param includingGroup The Role Group of which roles will be substracted
     * @param excludingGroup The Role Group which will be used to substract roles of the other Role Group
     */
    public DifferenceRoleGroup(RoleGroup includingGroup, RoleGroup excludingGroup) {
        this.includingGroup = includingGroup;
        this.excludingGroup = excludingGroup;
    }
    
    @Override
    public Set<Role> getRoles() {
        Set<Role> roles = includingGroup.getRoles();
        roles.removeAll(excludingGroup.getRoles());
        return roles;
    }
    
}
