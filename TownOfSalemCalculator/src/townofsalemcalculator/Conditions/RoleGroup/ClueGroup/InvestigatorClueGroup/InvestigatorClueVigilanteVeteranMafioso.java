package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.InvestigatorClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.FullInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group for which the Investigator sees that it is a Vigilante, Veteran or Mafioso
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-20
 */
public class InvestigatorClueVigilanteVeteranMafioso extends FullInclude {
    
    public InvestigatorClueVigilanteVeteranMafioso(Set<Role> amnesiacTurnedInto) {
        super(new InvestigatorInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class InvestigatorInnerClueGroup extends CompositeRoleGroup {    
        public InvestigatorInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Vigilante));
            addRoleGroup(new SingleRoleGroup(Veteran));
            addRoleGroup(new SingleRoleGroup(Mafioso));
        }
    }
}
