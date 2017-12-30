package townofsalemcalculator.RoleGroup.NeutralGroup;

import townofsalemcalculator.RoleGroup.CompositeRoleGroup;

/**
 * The All Neutral Non Coven Group, includes all Neutral roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class NeutralGroupNonCoven extends CompositeRoleGroup {
    public NeutralGroupNonCoven() {
        addRoleGroup(new NeutralBenignNonCoven());
        addRoleGroup(new NeutralChaosNonCoven());
        addRoleGroup(new NeutralEvilNonCoven());
        addRoleGroup(new NeutralKillingNonCoven());
    }
}
