package townofsalemcalculator.RoleGroup.ClueGroup.DetermineGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Witch;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
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
public final class TownHostileNonCoven extends StandardInclude {
    public TownHostileNonCoven(Set<Role> amnesiacTurnedInto) {
        super(new TownHostileNonCovenInner(), amnesiacTurnedInto);
    }
    
    static class TownHostileNonCovenInner extends CompositeRoleGroup {
        public TownHostileNonCovenInner() {
            addRoleGroup(new MafiaGroupNonCoven());
            addRoleGroup(new NeutralKillingNonCoven());
            addRoleGroup(new SingleRoleGroup(Witch));
        }
    }
}
