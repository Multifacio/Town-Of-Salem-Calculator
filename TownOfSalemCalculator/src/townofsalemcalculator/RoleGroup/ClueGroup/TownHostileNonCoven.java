package townofsalemcalculator.RoleGroup.ClueGroup;

import static townofsalemcalculator.Role.Witch;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.RoleGroup.NeutralGroup.NeutralKillingNonCoven;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Role Group that must be killed by the Town
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-6
 */
public class TownHostileNonCoven extends CompositeRoleGroup {
    public TownHostileNonCoven() {
        addRoleGroup(new MafiaGroupNonCoven());
        addRoleGroup(new NeutralKillingNonCoven());
        addRoleGroup(new SingleRoleGroup(Witch));
    }
}
