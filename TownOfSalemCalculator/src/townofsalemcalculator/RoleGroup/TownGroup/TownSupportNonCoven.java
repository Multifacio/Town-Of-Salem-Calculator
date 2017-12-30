package townofsalemcalculator.RoleGroup.TownGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Town Support Non Coven Group, includes all Town Support roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class TownSupportNonCoven extends CompositeRoleGroup {   
    public TownSupportNonCoven() {
        addRoleGroup(new SingleRoleGroup(Escort));
        addRoleGroup(new SingleRoleGroup(Mayor));
        addRoleGroup(new SingleRoleGroup(Medium));
        addRoleGroup(new SingleRoleGroup(Retributionist));
        addRoleGroup(new SingleRoleGroup(Transporter));
    }
}
