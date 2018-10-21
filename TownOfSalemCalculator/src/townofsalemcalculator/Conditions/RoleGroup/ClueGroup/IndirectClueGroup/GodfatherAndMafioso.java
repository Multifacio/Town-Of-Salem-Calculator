package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup;

import static townofsalemcalculator.Role.Godfather;
import static townofsalemcalculator.Role.Mafioso;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The group consisting of both the Godfather and the Mafioso
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-7
 */
public final class GodfatherAndMafioso extends CompositeRoleGroup {
    public GodfatherAndMafioso() {
        addRoleGroup(new SingleRoleGroup(Godfather));
        addRoleGroup(new SingleRoleGroup(Mafioso));
    }
}
