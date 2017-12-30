package townofsalemcalculator.Conditions.BasicConditions;

import java.util.List;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Player;
import townofsalemcalculator.StartCategory;

/**
 * The condition that all Start Categories are mapped to Players
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class StartCategoriesToPlayers implements Condition {
    private final List<Player> players; //The list of all Players participating in a game
    private final List<StartCategory> startCategories; //The list of all Start Categories in a game
    
    /**
     * Create a Start Categories To Players condition
     * @param players The list of all Players participating in a game
     * @param startCategories The list of all Start Categories in a game
     */
    public StartCategoriesToPlayers(List<Player> players, List<StartCategory> startCategories) {
        this.players = players;
        this.startCategories = startCategories;
    }
}
