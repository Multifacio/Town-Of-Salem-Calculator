package townofsalemcalculator.RoleGroup;

import java.util.HashMap;
import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.MafiaExceptGodfatherAndMafioso;

/**
 * The Role Group that add all roles that can become any role in the Role Group
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-7
 */
public final class BecomeRoles extends CompositeRoleGroup {
    public BecomeRoles(RoleGroup roleGroup) {
        addRoleGroup(roleGroup); 
        Set<Role> becomeRoles = roleGroupThatCanBecomeRole().keySet(); //Roles which other roles can become
        boolean addedRoles; //Check whether new roles are added because another role is contained within the becomeRole set
        do {
            addedRoles = false;
            for (Role r : becomeRoles) { //For each role in the set of becomeRoles check whether it exist in the roles that were already found
                if (getRoles().contains(r)) { 
                    addRoleGroup(roleGroupThatCanBecomeRole().get(r)); //Add the roles that can turn into this role in this Role Group
                    becomeRoles.remove(r); //Remove this role from the becomeRoles list such that the roles that can become this role are not added twice
                    addedRoles = true; //The role group is updated, so the while loop can check again for the newly added roles
                }
            }
        } while (addedRoles);
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
