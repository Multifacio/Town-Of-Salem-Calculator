package townofsalemcalculator.RoleGroup.MafiaGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Mafia Support Non Coven Group, includes all Mafia Support roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class MafiaSupportNonCoven extends CompositeRoleGroup {
    public MafiaSupportNonCoven() {
        addRoleGroup(new SingleRoleGroup(Blackmailer));
        addRoleGroup(new SingleRoleGroup(Consigliere));
        addRoleGroup(new SingleRoleGroup(Consort));
    }
}
