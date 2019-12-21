package townofsalemcalculator.Conditions.RoleGroup.MafiaGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

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
