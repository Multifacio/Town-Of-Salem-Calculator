package townofsalemcalculator.RoleGroup.MafiaGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Mafia Killing Non Coven Group, includes all Mafia Killing roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class MafiaKillingNonCoven extends CompositeRoleGroup {
    public MafiaKillingNonCoven() {
        addRoleGroup(new SingleRoleGroup(Godfather));
        addRoleGroup(new SingleRoleGroup(Mafioso));
    }
}
