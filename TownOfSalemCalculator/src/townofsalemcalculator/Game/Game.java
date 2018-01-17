package townofsalemcalculator.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.ConcreteConditions.ConcreteCondition;
import townofsalemcalculator.GameModus;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.ClueGroup.DetermineGroup.TownFriendlyNonCoven;
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
    private Map<Player, Double> goodLikelihood; //Contains the likelihood that a player is not the opposite of town
    private Map<Player, Double> claimLikelihood; //Contains the likelihood of a claim for each player
    
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
        class MultithreadedSimulation implements Runnable {
            private double likelihood;
            private final AbstractCondition check;
            private final List<ConcreteCondition> holds;
            
            public MultithreadedSimulation(AbstractCondition check, List<ConcreteCondition> holds) {
                this.check = check;
                this.holds = holds;
            }
            
            @Override
            public void run() {
                likelihood = simulation.doSimulation(check, holds);
            } 
            
            public double getLikelihood() {
                return likelihood;
            }
        }
        
        Map<Player, Thread> goodLikelihoodThreads = new HashMap(); //Contains all threads that calculate the good likelihood of the players
        Map<Player, Double> claimLikelihoodThreads = new HashMap(); //Contains all threads that calculate the claim likelihood of the players
        
        //Run different threads that calculate the good likelihood of the players
        for (Player p : players) {
            AbstractCondition check = new EitherRoleForRoleSelecter(p, new TownFriendlyNonCoven()); //The condition which will be checked
            //Create a new thread that will be runned
            MultithreadedSimulation mts = new MultithreadedSimulation(check, conditions);
            Thread t = new Thread(mts);
            t.start();
            goodLikelihoodThreads.put(p, t); //Add the thread to the map
        }
    }
}
