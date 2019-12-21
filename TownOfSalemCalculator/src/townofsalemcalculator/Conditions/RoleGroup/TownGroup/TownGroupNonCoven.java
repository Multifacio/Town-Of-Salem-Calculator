package townofsalemcalculator.Conditions.RoleGroup.TownGroup;

import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;

/**
 * The All Town Non Coven Group, includes all Town Roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class TownGroupNonCoven extends CompositeRoleGroup {
    public TownGroupNonCoven() {
        addRoleGroup(new TownInvestigativeNonCoven());
        addRoleGroup(new TownKillingNonCoven());
        addRoleGroup(new TownProtectiveNonCoven());
        addRoleGroup(new TownSupportNonCoven());
    }
}
