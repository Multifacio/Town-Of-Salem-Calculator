package townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.HashMap;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.MafiaExceptGodfatherAndMafioso;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Role Group that add all roles that can become any role in the Role Group
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-7
 */
public final class BecomeRoles extends CompositeRoleGroup {
    public BecomeRoles(RoleGroup roleGroup) {
        addRoleGroup(roleGroup); 
        HashMap<Role, RoleGroup> roleBecomeMapping = roleGroupThatCanBecomeRole();
        for (Role r : roleBecomeMapping.keySet()) { //For each role that other roles can become check whether it is contained in this Role Group
            if (roleGroup.getRoles().contains(r)) { 
                addRoleGroup(roleBecomeMapping.get(r)); //Add the roles that can turn into this role to this Role Group
            }
        }
    }
    
    //Contains the Role Group that can become a certain role (if a role is not added then nobody can become that role)
    private HashMap<Role, RoleGroup> roleGroupThatCanBecomeRole() {
        HashMap<Role, RoleGroup> roleBecomeMapping = new HashMap();
        
        roleBecomeMapping.put(Godfather, new SingleRoleGroup(Mafioso));
        roleBecomeMapping.put(Mafioso, new MafiaExceptGodfatherAndMafioso());
        roleBecomeMapping.put(Vigilante, new SingleRoleGroup(VampireHunter));
        roleBecomeMapping.put(Jester, new SingleRoleGroup(Executioner));
        return roleBecomeMapping;
    }
}
