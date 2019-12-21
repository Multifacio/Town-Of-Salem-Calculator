package townofsalemcalculator.Conditions.RoleGroup;

import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;

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
