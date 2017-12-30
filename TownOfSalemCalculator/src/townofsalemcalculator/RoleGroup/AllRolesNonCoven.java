package townofsalemcalculator.RoleGroup;

import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.RoleGroup.NeutralGroup.NeutralGroupNonCoven;
import townofsalemcalculator.RoleGroup.TownGroup.TownGroupNonCoven;

/**
 * The All Roles Non Coven Group, includes all Roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class AllRolesNonCoven extends CompositeRoleGroup {
    public AllRolesNonCoven() {
        addRoleGroup(new TownGroupNonCoven());
        addRoleGroup(new MafiaGroupNonCoven());
        addRoleGroup(new NeutralGroupNonCoven());
    }
}
