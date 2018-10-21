package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup;

import static townofsalemcalculator.Role.Godfather;
import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

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
