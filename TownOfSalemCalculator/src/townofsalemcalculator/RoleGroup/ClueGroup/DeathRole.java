package townofsalemcalculator.RoleGroup.ClueGroup;

import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Disguiser;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * When someone dies its Role will be known, so then it belongs to this RoleGroup
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public final class DeathRole extends CompositeRoleGroup {
    public DeathRole(Role role) {
        addRoleGroup(new SingleRoleGroup(role));
        addRoleGroup(new SingleRoleGroup(Disguiser));
    }
}
