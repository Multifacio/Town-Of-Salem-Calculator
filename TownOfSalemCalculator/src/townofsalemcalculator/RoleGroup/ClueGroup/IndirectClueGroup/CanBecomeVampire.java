package townofsalemcalculator.RoleGroup.ClueGroup.IndirectClueGroup;

import static townofsalemcalculator.Role.Executioner;
import static townofsalemcalculator.Role.Jester;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.NeutralGroup.NeutralBenignNonCoven;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.RoleGroup.TownGroup.TownGroupNonCoven;

/**
 * The group consisting of all roles that can become a Vampire
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-21
 */
public class CanBecomeVampire extends CompositeRoleGroup {
    
    public CanBecomeVampire() {
        addRoleGroup(new TownGroupNonCoven());
        addRoleGroup(new NeutralBenignNonCoven());
        addRoleGroup(new SingleRoleGroup(Jester));
        addRoleGroup(new SingleRoleGroup(Executioner));
    }
    
}
