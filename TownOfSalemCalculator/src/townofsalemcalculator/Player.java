package townofsalemcalculator;

/**
 * A Player is someone that participates in the game
 * @author Multifacio
 * @version 1.1
 * @since 2017-12-30
 */
public class Player {
    private final String username; //The username of the player (for example: Sarah Bishop, John Proctor)
    private final int position; //The position of the player in the list of players (1 upto 15)
    
    /**
     * Create a Player with an username and position
     * @param username The username of the player (for example: Sarah Bishop, John Proctor)
     * @param position The position of the player in the list of players (1 upto 15)
     */
    public Player(String username, int position) {
        this.username = username;
        this.position = position;
    }
    
    /**
     * Get the username of the player
     * @return The username of the player
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Get the position of the player in the list of players
     * @return The position of the player in the list of players (1 upto 15)
     */
    public int getPosition() {
        return position;
    }
}
