package townofsalemcalculator.Conditions.RoleGroup.NeutralGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

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
