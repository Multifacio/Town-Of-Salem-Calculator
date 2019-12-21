package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Amnesiac;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * Include the Amnesiac to this Role Group if the Amnesiac has turned into any role that is included in this Role Group
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-18
 */
public class IncludingAmnesiac implements RoleGroup {
    private final RoleGroup roleGroup; //The included Role Group
    private final Set<Role> amnesiacTurnedInto; //All roles which an Amnesiac has turned into
    
    /**
     * Create an Including Amnesiac Role Group
     * @param roleGroup The Role Group which is included in this Role Group and will be checked if any Amnesiac has turned into this group
     * @param amnesiacTurnedInto The set of all roles in which an Amnesiac has turned into
     */
    public IncludingAmnesiac(RoleGroup roleGroup, Set<Role> amnesiacTurnedInto) {
        this.roleGroup = roleGroup;
        this.amnesiacTurnedInto = amnesiacTurnedInto;
    }

    @Override
    public Set<Role> getRoles() {
        class IncludingAmnesiacInner extends IncludeRoleGroupIfRoleExist {
            public IncludingAmnesiacInner(RoleGroup roleGroup) {
                super(roleGroup);
            }

            @Override
            public HashMap<Role, RoleGroup> getRoleIncludeMapping() {
                HashMap<Role, RoleGroup> roleIncludeMapping = new HashMap();
                Iterator<Role> iterator = amnesiacTurnedInto.iterator();
                while(iterator.hasNext()) {
                    roleIncludeMapping.put(iterator.next(), new SingleRoleGroup(Amnesiac));
                }
                return roleIncludeMapping;
            }
        
        }
        
        RoleGroup rg = new IncludingAmnesiacInner(roleGroup);
        return rg.getRoles();
    }
}
