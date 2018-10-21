package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.KillingClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group of players that have basic defense without getting killed by Veteran
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-24
 */
public class BasicDefenseClueGroup extends StandardInclude {
    
    public BasicDefenseClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new BasicDefenseInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class BasicDefenseInnerClueGroup extends CompositeRoleGroup {    
        public BasicDefenseInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Bodyguard));
            addRoleGroup(new SingleRoleGroup(Godfather));
            addRoleGroup(new SingleRoleGroup(Survivor));
            addRoleGroup(new SingleRoleGroup(Executioner));
            addRoleGroup(new SingleRoleGroup(Witch));
            addRoleGroup(new SingleRoleGroup(Arsonist));
            addRoleGroup(new SingleRoleGroup(SerialKiller));
            addRoleGroup(new SingleRoleGroup(Werewolf));
        }
    }
}
