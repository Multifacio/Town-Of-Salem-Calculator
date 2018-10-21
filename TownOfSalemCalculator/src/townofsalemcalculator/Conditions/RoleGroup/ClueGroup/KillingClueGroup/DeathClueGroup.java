package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.KillingClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group of a Death Player when its role is shown
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-25
 */
public class DeathClueGroup extends FullInclude {
    public DeathClueGroup(Role role, Set<Role> amnesiacTurnedInto) {
        super(new SingleRoleGroup(role), amnesiacTurnedInto);
    }  
}
