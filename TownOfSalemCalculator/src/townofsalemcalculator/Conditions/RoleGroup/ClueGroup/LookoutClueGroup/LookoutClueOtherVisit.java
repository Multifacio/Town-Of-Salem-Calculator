package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.LookoutClueGroup;

import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The role group of a player that visited another person
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-21
 */
public class LookoutClueOtherVisit extends StandardInclude {
    
    public LookoutClueOtherVisit(Set<Role> amnesiacTurnedInto) {
        super(new LookoutInnerClueGroup(), amnesiacTurnedInto);
    }  
    
    static class LookoutInnerClueGroup extends CompositeRoleGroup {    
        public LookoutInnerClueGroup() {
            addRoleGroup(new SingleRoleGroup(Investigator));
            addRoleGroup(new SingleRoleGroup(Lookout));
            addRoleGroup(new SingleRoleGroup(Sheriff));
            addRoleGroup(new SingleRoleGroup(Spy));
            addRoleGroup(new SingleRoleGroup(VampireHunter));
            addRoleGroup(new SingleRoleGroup(Vigilante));
            addRoleGroup(new SingleRoleGroup(Bodyguard));
            addRoleGroup(new SingleRoleGroup(Doctor));
            addRoleGroup(new SingleRoleGroup(Escort));
            addRoleGroup(new SingleRoleGroup(Transporter));
            addRoleGroup(new SingleRoleGroup(Disguiser));
            addRoleGroup(new SingleRoleGroup(Forger));
            addRoleGroup(new SingleRoleGroup(Framer));
            addRoleGroup(new SingleRoleGroup(Janitor));
            addRoleGroup(new SingleRoleGroup(Godfather));
            addRoleGroup(new SingleRoleGroup(Mafioso));
            addRoleGroup(new SingleRoleGroup(Blackmailer));
            addRoleGroup(new SingleRoleGroup(Consigliere));
            addRoleGroup(new SingleRoleGroup(Consort));
            addRoleGroup(new SingleRoleGroup(Witch));
            addRoleGroup(new SingleRoleGroup(Vampire));
            addRoleGroup(new SingleRoleGroup(Arsonist));
            addRoleGroup(new SingleRoleGroup(SerialKiller));
            addRoleGroup(new SingleRoleGroup(Werewolf));
        }
    }
}
