package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.SheriffClueGroup;

import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup.MafiaExceptGodfather;
import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;

/**
 * The role group of the player for which the Sheriff gets the message that he is member of the Mafia
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-17
 */
public class SheriffMemberOfMafiaClueGroup extends StandardInclude {
    
    public SheriffMemberOfMafiaClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new MafiaExceptGodfather(), amnesiacTurnedInto);
    }  
}
