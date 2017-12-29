package townofsalemcalculator;

/**
 * The Start Categories determine which roles might appear in the game. For example in Ranked Practise
 * you have: Jailor, 2x Town Investigative, 1x Town Support, etcetera. All these four are Start Categories
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-29
 */
public class StartCategory extends RoleSelecter {
    
    /**
     * Create a Start Category with an identifier
     * @param id The identifier of the player (do not use the same id for two Role Selecters)
     */
    public StartCategory(int id) {
        super(id);
    }
    
}
