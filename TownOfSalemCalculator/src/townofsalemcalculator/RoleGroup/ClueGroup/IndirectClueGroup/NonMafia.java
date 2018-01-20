package townofsalemcalculator.RoleGroup.ClueGroup.IndirectClueGroup;

import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;

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
