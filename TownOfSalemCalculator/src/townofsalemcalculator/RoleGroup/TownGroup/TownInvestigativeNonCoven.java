package townofsalemcalculator.RoleGroup.TownGroup;

import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Town Investigative Non Coven Group, includes all Town Investigative roles except the Coven Expansion roles
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class TownInvestigativeNonCoven extends CompositeRoleGroup {
    public TownInvestigativeNonCoven() {
        addRoleGroup(new SingleRoleGroup(Investigator));
        addRoleGroup(new SingleRoleGroup(Lookout));
        addRoleGroup(new SingleRoleGroup(Sheriff));
        addRoleGroup(new SingleRoleGroup(Spy));
    }
}
