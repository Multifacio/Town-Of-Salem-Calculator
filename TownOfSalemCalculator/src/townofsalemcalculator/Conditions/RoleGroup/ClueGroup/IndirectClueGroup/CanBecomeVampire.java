package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup;

import static townofsalemcalculator.Role.Executioner;
import static townofsalemcalculator.Role.Jester;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralBenignNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownGroupNonCoven;

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
