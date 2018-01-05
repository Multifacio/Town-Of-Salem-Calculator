package townofsalemcalculator.AbstractConditions.AdvancedConditions;

import java.util.List;
import townofsalemcalculator.AbstractConditions.CompositeCondition;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.Game.StartCategory;

/**
 * The Condition that all Start Categories and all Players have exactly 1 role.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public final class EveryoneExactly1Role extends CompositeCondition {
    /**
     * Create an Everyone Exactly 1 Role condition
     * @param players The list of all Players participating in a game
     * @param startCategories The list of all Start Categories in a game
     */
    public EveryoneExactly1Role(List<Player> players, List<StartCategory> startCategories) {
        //Set the exactly 1 role condition for all Players
        for(Player p : players) {
            addCondition(new EitherRoleForRoleSelecter(p, new AllRoles()));
        }
        
        //Set the exactly 1 role condition for all Start Categories
        for(StartCategory sc : startCategories) {
            addCondition(new EitherRoleForRoleSelecter(sc, new AllRoles()));
        }
    }
}