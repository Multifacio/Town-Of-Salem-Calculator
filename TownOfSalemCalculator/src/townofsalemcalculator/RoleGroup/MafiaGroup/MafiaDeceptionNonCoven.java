package townofsalemcalculator.RoleGroup.MafiaGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Mafia Deception Non Coven Group, includes all Mafia Deception roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class MafiaDeceptionNonCoven extends CompositeRoleGroup {
    public MafiaDeceptionNonCoven() {
        addRoleGroup(new SingleRoleGroup(Disguiser));
        addRoleGroup(new SingleRoleGroup(Forger));
        addRoleGroup(new SingleRoleGroup(Framer));
        addRoleGroup(new SingleRoleGroup(Janitor));
    }
}
