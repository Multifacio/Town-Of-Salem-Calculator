package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import java.util.List;
import static townofsalemcalculator.Comparison.GreaterOrEqual;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.RoleGroupAmount;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;

/**
 * The Condition that a Role must occur a minimum amount of times. For example that there exist a Serial Killer in the game.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class MinimumRoleAmount extends RoleGroupAmount {
    
    /**
     * Create a Minimum Role Amount condition
     * @param startCategories The list of all Start Categories in a game
     * @param role The role that must occur at least amount times in the game
     * @param amount The amount of times role must occur at least in the game
     */
    public MinimumRoleAmount(List<StartCategory> startCategories, Role role, int amount) {
        super(startCategories, new SingleRoleGroup(role), GreaterOrEqual, amount);
    }
    
    /**
     * Create a Minimum Role Amount condition
     * @param startCategories The list of all Start Categories in a game
     * @param roleGroup The roleGroup that must occur at least amount times in the game
     * @param amount The amount of times role must occur at least in the game
     */
    public MinimumRoleAmount(List<StartCategory> startCategories, RoleGroup roleGroup, int amount) {
        super(startCategories, roleGroup, GreaterOrEqual, amount);
    }
}
