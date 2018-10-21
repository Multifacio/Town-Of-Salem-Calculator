package townofsalemcalculator.Conditions.RoleGroup.TownGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Town Killing Non Coven Group, includes all Town Killing roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class TownKillingNonCoven extends CompositeRoleGroup {
    public TownKillingNonCoven() {
        addRoleGroup(new SingleRoleGroup(Jailor));
        addRoleGroup(new SingleRoleGroup(VampireHunter));
        addRoleGroup(new SingleRoleGroup(Veteran));
        addRoleGroup(new SingleRoleGroup(Vigilante));
    }
}
