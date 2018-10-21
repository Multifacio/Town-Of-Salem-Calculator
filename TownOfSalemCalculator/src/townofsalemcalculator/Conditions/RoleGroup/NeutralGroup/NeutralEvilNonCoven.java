package townofsalemcalculator.Conditions.RoleGroup.NeutralGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Neutral Evil Non Coven Group, includes all Neutral Evil roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class NeutralEvilNonCoven extends CompositeRoleGroup {
    public NeutralEvilNonCoven() {
        addRoleGroup(new SingleRoleGroup(Executioner));
        addRoleGroup(new SingleRoleGroup(Jester));
        addRoleGroup(new SingleRoleGroup(Witch));
    }
}
