package townofsalemcalculator.Conditions.RoleGroup;

import java.util.HashSet;
import java.util.Set;
import townofsalemcalculator.Role;

/**
 * A Single Role Group is a Role Group that only consists of 1 Role
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class SingleRoleGroup implements RoleGroup {
    private final Role role; //The only Role that is included in this Single Role Group
    
    /**
     * Create a Single Role Group with a Role
     * @param role The only Role that is included in this Single Role Group
     */
    public SingleRoleGroup(Role role) {
        this.role = role;
    } 

    @Override
    public Set<Role> getRoles() {
        HashSet<Role> roles = new HashSet();
        roles.add(role); //Add the only Role of this Single Role Group to the set
        return roles;
    }
    
}
