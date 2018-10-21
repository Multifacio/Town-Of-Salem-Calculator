package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import java.util.List;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.RoleRoleDependency;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.StartCategoriesToPlayers;
import townofsalemcalculator.Conditions.Abstract.CompositeCondition;
import townofsalemcalculator.Game.Player;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Game.StartCategory;

/**
 * All conditions that hold in every Town of Salem game are included here
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public final class GameCondition extends CompositeCondition {
    public GameCondition(List<Player> players, List<StartCategory> startCategories) {
        //Standard Conditions
        addCondition(new EveryoneExactly1Role(players, startCategories)); //All players and role categories have exactly 1 role
        addCondition(new StartCategoriesToPlayers(players, startCategories)); //All players have to get a categorie
        
        //Role Uniqueness Conditions
        addCondition(new RoleUniqueness(startCategories, Jailor));
        addCondition(new RoleUniqueness(startCategories, Mayor));
        addCondition(new RoleUniqueness(startCategories, Retributionist));
        addCondition(new RoleUniqueness(startCategories, Veteran));
        addCondition(new RoleUniqueness(startCategories, Godfather));
        addCondition(new RoleUniqueness(startCategories, Mafioso));
        addCondition(new RoleUniqueness(startCategories, Werewolf));
        
        //Vampire Hunter implies Vampire
        addCondition(new RoleRoleDependency(startCategories, VampireHunter, Vampire));
    }
}
