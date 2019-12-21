package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.DetermineGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.AllRolesNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;

/**
 * The Role Group that does not have to be killed by the Town
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-6
 */
public final class TownFriendlyNonCoven extends DifferenceRoleGroup {
    
    public TownFriendlyNonCoven(Set<Role> amnesiacTurnedInto) {
        super(new AllRolesNonCoven(), new TownHostileNonCoven(amnesiacTurnedInto));
    }
    
}
