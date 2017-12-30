package townofsalemcalculator.RoleGroup.TownGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Town Protective Non Coven Group, includes all Town Protective roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class TownProtectiveNonCoven extends CompositeRoleGroup {
    public TownProtectiveNonCoven() {
        addRoleGroup(new SingleRoleGroup(Bodyguard));
        addRoleGroup(new SingleRoleGroup(Doctor));
    }
}