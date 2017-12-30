package townofsalemcalculator.RoleGroup.NeutralGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Neutral Benign Non Coven Group, includes all Neutral Benign roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class NeutralBenignNonCoven extends CompositeRoleGroup {
    public NeutralBenignNonCoven() {
        addRoleGroup(new SingleRoleGroup(Amnesiac));
        addRoleGroup(new SingleRoleGroup(Survivor));
    }
}
