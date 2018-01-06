package townofsalemcalculator.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import townofsalemcalculator.ConcreteConditions.ConcreteCondition;
import townofsalemcalculator.GameModus;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_Simulation;
import townofsalemcalculator.Simulations.Simulation;

/**
 * A Game contains all information about a Game of Town of Salem
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-6
 */
public class Game {
    //All variables that are only changed in the initializeGame method
    private List<Player> players; //The list of all Players participating in a game
    private List<StartCategory> startCategories; //The list of all Start Categories in a game
    private Simulation simulation; //The simulation that will be used to check the likelihood of conditions
    
    private List<ConcreteCondition> conditions; //The list of all conditions that are known to be true
    private Map<Player, Double> claimLikelihood; //Contains the likelihood of a claim for each player
    private Map<Player, Double> goodLikelihood; //Contains the likelihood that a player is good

    public Game() {
        conditions = new ArrayList();
        players = new ArrayList();
        startCategories = new ArrayList();
        claimLikelihood = new HashMap();
        goodLikelihood = new HashMap();
    }
    
    /**
     * Initialize the Game (prepare the start of a Game)
     * @param playerNames The array of all player names
     * @param ownPosition Your own position in the player list
     * @param ownRole Your own role
     * @param gameModus The Game Modus of the Game
     */
    public void initializeGame(String[] playerNames, int ownPosition, Role ownRole, GameModus gameModus) {
        int i = 0;
        for (String name : playerNames) { //Add all players to the game
            players.add(new Player(i, name, i + 1));
            i++;
        }
        for (String name : playerNames) { //Add all start categories to the game
            startCategories.add(new StartCategory(i));
            i++;
        }
        simulation = new PCLO_Simulation(players, startCategories); //Determines which simulation implementation will be used
    }
    
    /**
     * Add a new condition to the Game
     * @param condition The condition which is known to be true about the game
     */
    public void addCondition(ConcreteCondition condition) {
        conditions.add(condition);
    }
    
    public void updateInformationWithSimulation() {
        //
        for (Player p : players) {
            double likelihood = simulation.doSimulation(new EitherRoleForRoleSelecter(p, ), conditions);
        }
    }
}
