package townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.HashMap;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.RoleGroup;

/**
 * The Role Group that includes a Role Group if some other Role exist in the group
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-18
 */
public abstract class IncludeRoleGroupIfRoleExist extends CompositeRoleGroup {
    public IncludeRoleGroupIfRoleExist(RoleGroup roleGroup) {
        addRoleGroup(roleGroup); 
        HashMap<Role, RoleGroup> roleIncludeMapping = getRoleIncludeMapping();
        for (Role r : roleIncludeMapping.keySet()) { //For each role that includes other roles check whether it is contained in this Role Group
            if (roleGroup.getRoles().contains(r)) { 
                addRoleGroup(roleIncludeMapping.get(r)); //Add the Role Group that include this role to the Role Group
            }
        }
    }
    
    /**
     * Get the mapping that defines which Role Group gets included if some Role exist in this Role group 
     * @return The mapping that defines which Role Group gets included if some Role exist in this Role group 
     */
    public abstract HashMap<Role, RoleGroup> getRoleIncludeMapping();
}
