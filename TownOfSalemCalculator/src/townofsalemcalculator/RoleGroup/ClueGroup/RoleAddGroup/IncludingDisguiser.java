package townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup;

import static townofsalemcalculator.Role.Disguiser;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * When someone dies its Role will be known, so then it belongs to this RoleGroup
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public final class IncludingDisguiser extends CompositeRoleGroup {
    public IncludingDisguiser(RoleGroup roleGroup) {
        addRoleGroup(roleGroup);
        addRoleGroup(new SingleRoleGroup(Disguiser));
    }
}
