package townofsalemcalculator.Conditions.Abstract.GameModusConditions;

import java.util.List;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Conditions.Abstract.CompositeCondition;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Game.StartCategory;

/**
 * A Game Modus is a condition that determines what roles the Start Categories can be
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public abstract class GameModusAbstractCondition extends CompositeCondition {
    private final List<StartCategory> startCategories; //The list of all Start Categories in a game
    
    /**
     * Create a GameModus condition
     * @param startCategories The list of all Start Categories in a game
     */
    public GameModusAbstractCondition(List<StartCategory> startCategories) {
        this.startCategories = startCategories;
        initialize();
    }
    
    private void initialize() {
        for(int i = 0; i < startCategories.size(); i++) {
            addCondition(new EitherRoleForRoleSelecter(startCategories.get(i), getLinkedRoleGroups()[i]));
        }
    }
    
    /**
     * Get the array of Role Groups that are included in this Game Modus
     * @return The array of Role Groups that are included in this Game Modus
     */
    protected abstract RoleGroup[] getLinkedRoleGroups();
}
