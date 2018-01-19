package townofsalemcalculator.RoleGroup.ClueGroup.RemainderGroup;

import static townofsalemcalculator.Role.Godfather;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The group consisting of all Mafia roles except the Godfather
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-19
 */
public class MafiaExceptGodfather extends DifferenceRoleGroup {   
    public MafiaExceptGodfather() {
        super(new MafiaGroupNonCoven(), new SingleRoleGroup(Godfather));
    }
}
