package townofsalemcalculator.RoleGroup.NeutralGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Neutral Chaos Non Coven Group, includes all Neutral Chaos roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class NeutralChaosNonCoven extends CompositeRoleGroup {
    public NeutralChaosNonCoven() {
        addRoleGroup(new SingleRoleGroup(Vampire));
    }
}
