package townofsalemcalculator.RoleGroup.ClueGroup.DetermineGroup;

import townofsalemcalculator.RoleGroup.AllRolesNonCoven;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;

/**
 * The Role Group that does not have to be killed by the Town
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-6
 */
public final class TownFriendlyNonCoven extends DifferenceRoleGroup {
    
    public TownFriendlyNonCoven() {
        super(new AllRolesNonCoven(), new TownHostileNonCoven());
    }
    
}
