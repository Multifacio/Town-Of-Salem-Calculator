package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup;

import static townofsalemcalculator.Role.Disguiser;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * When someone dies its Role will be known, so then it belongs to this Role Group
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public class IncludingDisguiser extends CompositeRoleGroup {
    public IncludingDisguiser(RoleGroup roleGroup) {
        addRoleGroup(roleGroup);
        addRoleGroup(new SingleRoleGroup(Disguiser));
    }
}
