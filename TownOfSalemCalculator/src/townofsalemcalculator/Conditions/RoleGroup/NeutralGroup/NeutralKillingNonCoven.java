package townofsalemcalculator.Conditions.RoleGroup.NeutralGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Neutral Killing Non Coven Group, includes all Neutral Killing roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class NeutralKillingNonCoven extends CompositeRoleGroup {
    public NeutralKillingNonCoven() {
        addRoleGroup(new SingleRoleGroup(Arsonist));
        addRoleGroup(new SingleRoleGroup(SerialKiller));
        addRoleGroup(new SingleRoleGroup(Werewolf));
    }
}
