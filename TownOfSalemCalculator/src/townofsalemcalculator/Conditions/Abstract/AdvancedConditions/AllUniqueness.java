package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import townofsalemcalculator.Conditions.Abstract.BasicConditions.RoleUniqueness;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.CompositeCondition;
import static townofsalemcalculator.Role.*;

/**
 * All roles that are unique are included in this condition
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-30
 */
public final class AllUniqueness extends CompositeCondition {
    public AllUniqueness() {
        addCondition(new RoleUniqueness(Jailor));
        addCondition(new RoleUniqueness(Mayor));
        addCondition(new RoleUniqueness(Retributionist));
        addCondition(new RoleUniqueness(Veteran));
        addCondition(new RoleUniqueness(Godfather));
        addCondition(new RoleUniqueness(Mafioso));
        addCondition(new RoleUniqueness(Werewolf));
    }
}
