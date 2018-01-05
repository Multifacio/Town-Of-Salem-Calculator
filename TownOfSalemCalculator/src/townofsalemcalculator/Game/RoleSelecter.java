package townofsalemcalculator.Game;

/**
 * A Role Selecter is something that can have a Role
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-29
 */
public class RoleSelecter {
    private final int id; //The identifier of the Role Selecter
    
    /**
     * Create a Role Selecter with an identifier
     * @param id The identifier of the Role Selecter (do not use the same id for two Role Selecters)
     */
    public RoleSelecter(int id) {
        this.id = id;
    }
    
    /**
     * Get the identifier of the Role Selecter
     * @return The identifier of the Role Selecter
     */
    public int getId() {
        return id;
    }
}
