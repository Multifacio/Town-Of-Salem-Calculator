package townofsalemcalculator.Conditions.AdvancedConditions;

import java.util.List;
import static townofsalemcalculator.Comparison.LesserOrEqual;
import townofsalemcalculator.Conditions.BasicConditions.RoleGroupAmount;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.StartCategory;

/**
 * The Condition that a Role must occur a maximum amount of times. For example that there is at most one Mayor in the game.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class MaximumRoleAmount extends RoleGroupAmount {
    
    /**
     * Create a Maximum Role Amount condition
     * @param startCategories The list of all Start Categories in a game
     * @param role The role that must occur at most amount times in the game
     * @param amount The amount of times role must occur at most in the game
     */
    public MaximumRoleAmount(List<StartCategory> startCategories, Role role, int amount) {
        super(startCategories, new SingleRoleGroup(role), LesserOrEqual, amount);
    }
    
}
