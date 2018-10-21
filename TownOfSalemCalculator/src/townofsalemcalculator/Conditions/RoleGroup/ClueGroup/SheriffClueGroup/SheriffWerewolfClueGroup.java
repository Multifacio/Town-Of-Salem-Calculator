package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.SheriffClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Werewolf;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group of the player for which the Sheriff gets the message that he is Werewolf
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-19
 */
public class SheriffWerewolfClueGroup extends StandardInclude {
    
    public SheriffWerewolfClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new SingleRoleGroup(Werewolf), amnesiacTurnedInto);
    }
}
