package townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The role group for which the Investigator sees that it is a Framer, Vampire, Jester
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-20
 */
public class InvestigatorClueFramerVampireJester extends FullInclude {
    
    public InvestigatorClueFramerVampireJester(Set<Role> amnesiacTurnedInto) {
        super(new InvestigatorInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class InvestigatorInnerClueGroup extends CompositeRoleGroup {    
        public InvestigatorInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Framer));
            addRoleGroup(new SingleRoleGroup(Vampire));
            addRoleGroup(new SingleRoleGroup(Jester));
        }
    }
}
