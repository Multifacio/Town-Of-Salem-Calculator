package townofsalemcalculator.Conditions.RoleGroup.MafiaGroup;

import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;

/**
 * The All Mafia Non Coven Group, includes all Mafia roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class MafiaGroupNonCoven extends CompositeRoleGroup {
    public MafiaGroupNonCoven() {
        addRoleGroup(new MafiaDeceptionNonCoven());
        addRoleGroup(new MafiaKillingNonCoven());
        addRoleGroup(new MafiaSupportNonCoven());
    }
}
