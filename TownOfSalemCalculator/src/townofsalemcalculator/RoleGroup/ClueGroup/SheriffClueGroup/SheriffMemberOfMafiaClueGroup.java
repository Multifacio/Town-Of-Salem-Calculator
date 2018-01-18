package townofsalemcalculator.RoleGroup.ClueGroup.SheriffClueGroup;

import static townofsalemcalculator.Role.Godfather;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group of the player for which the Sheriff gets the message that he is member of the Mafia
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-17
 */
public class SheriffMemberOfMafiaClueGroup extends DifferenceRoleGroup {
    
    public SheriffMemberOfMafiaClueGroup() {
        super(new MafiaGroupNonCoven(), new SingleRoleGroup(Godfather));
    }  
}
