package townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.HashMap;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.ClueGroup.IndirectClueGroup.MafiaExceptGodfatherAndMafioso;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Role Group that add all roles that can become any role in the Role Group
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-7
 */
public class IncludingBecomeRoles extends IncludeRoleGroupIfRoleExist {
    public IncludingBecomeRoles(RoleGroup roleGroup) {
        super(roleGroup);
    }
    
    //Contains the Role Group that can become a certain role (if a role is not added then nobody can become that role)
    @Override
    public HashMap<Role, RoleGroup> getRoleIncludeMapping() {
        HashMap<Role, RoleGroup> roleBecomeMapping = new HashMap();
        roleBecomeMapping.put(Godfather, new SingleRoleGroup(Mafioso));
        roleBecomeMapping.put(Mafioso, new MafiaExceptGodfatherAndMafioso());
        roleBecomeMapping.put(Vigilante, new SingleRoleGroup(VampireHunter));
        roleBecomeMapping.put(Jester, new SingleRoleGroup(Executioner));
        return roleBecomeMapping;
    }
}
