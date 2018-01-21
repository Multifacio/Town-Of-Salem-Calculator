package townofsalemcalculator.RoleGroup.ClueGroup.SpyClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.ClueGroup.IndirectClueGroup.NonMafia;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;

/**
 * The role group of the player for which the Spy sees that they were visited by Mafia
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-20
 */
public class SpyVisitedByMafiaClueGroup extends StandardInclude {
    public SpyVisitedByMafiaClueGroup(Set<Role> amnesiacTurnedInto) {
        super(new NonMafia(), amnesiacTurnedInto);
    }
}
