package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup;

import townofsalemcalculator.Conditions.RoleGroup.AllRoles;
import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;

/**
 * The group consisting of all roles except Mafia roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-20
 */
public class NonMafia extends DifferenceRoleGroup {
    
    public NonMafia() {
        super(new AllRoles(), new MafiaGroupNonCoven());
    }
    
}
