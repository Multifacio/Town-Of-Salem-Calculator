package townofsalemcalculator.AbstractConditions.AdvancedConditions;

import java.util.List;
import townofsalemcalculator.Role;
import townofsalemcalculator.StartCategory;

/**
 * The condition that a role must be unique (so at most 1 of this role). For example there cannot be 2 Veterans in the same game.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class RoleUniqueness extends MaximumRoleAmount {
    /**
     * Create a Role Uniqueness condition
     * @param startCategories The list of all Start Categories in a game
     * @param role The role which must be unique
     */
    public RoleUniqueness(List<StartCategory> startCategories, Role role) {
        super(startCategories, role, 1);
    }
}
