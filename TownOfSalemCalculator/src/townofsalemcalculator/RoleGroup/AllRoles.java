package townofsalemcalculator.RoleGroup;

import townofsalemcalculator.Role;

/**
 * The All Roles Group, includes all Roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class AllRoles extends CompositeRoleGroup {
    public AllRoles() {
        //Add all Roles of the enum
        for(Role r : Role.values()) {
            addRoleGroup(new SingleRoleGroup(r));
        }
    }
}
