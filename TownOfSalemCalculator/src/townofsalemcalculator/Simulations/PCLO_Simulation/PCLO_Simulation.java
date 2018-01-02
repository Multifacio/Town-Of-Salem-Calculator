package townofsalemcalculator.Simulations.PCLO_Simulation;

import java.util.List;
import scpsolver.problems.LPSolution;
import scpsolver.problems.LPWizard;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Counter;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.StartCategory;

/**
 * A Prioritized Condition Lineair Optimization simulation. It will determine how likely it is that a condition is true, based on other prioritized conditions.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-31
 */
public class PCLO_Simulation {
    private final List<Player> players; //The list of all Players participating in a game
    private final List<StartCategory> startCategories; //The list of all Start Categories in a game
    /* The difference between the maximal sum of priority values of the given Prioritized Conditions that can actually hold and the sum of priority values of 
    all given Prioritized Conditions. This double value give an indication about how much of the given Prioritized Condition can actually hold. The higher
    this value the less amount of the given Prioritized Conditions can hold */
    private double holdsLikelihood; 
    
    /**
     * Create a PCLO_Simulation
     * @param players The list of all Players participating in a game
     * @param startCategories The list of all Start Categories in a game
     */
    public PCLO_Simulation(List<Player> players, List<StartCategory> startCategories) {
        this.players = players;
        this.startCategories = startCategories;
        holdsLikelihood = 0.0;
    }
    
    /**
     * Get the difference between the maximal sum of priority values of the given Prioritized Conditions that can actually hold and the sum of priority values 
     * of all given Prioritized Conditions. 
     * @return This double value give an indication about how much of the given Prioritized Condition can actually hold. The 
     * higher this value the less amount of the given Prioritized Conditions can hold.
     */
    public double holdsLikelihood() {
        return holdsLikelihood;
    }
    
    /**
     * Check the likelihood of the check condition based on the hold conditions
     * @param check The condition of which the likelihood will be checked
     * @param holds The conditions which are known to may be hold
     * @return 
     */
    public int doSimulation(Condition check, List<PrioritizedCondition> holds) {
        LPWizard lpw = new LPWizard(); //Create a new Lineair Problem
        Counter counter = new Counter(); //Create a Counter that is initialized to zero (used to give different constraints a different naming)
        double sumOfPriorityValues = 0.0; //The total sum of priority values of the Prioritized Conditions
        for (int i = 0; i < holds.size(); i++) { //Loop through all Prioritized Conditions that hold
            PrioritizedCondition pc = holds.get(i);
            pc.addHoldCondition(lpw, counter, i); //Add this Prioritized Conditions to the Lineair Problem
            sumOfPriorityValues +=  pc.getPriority(); //Keep the sum of priority values up to date
        }
        setAllToBoolean(lpw, holds); //Set all lineair optimization variables to booleans
        lpw.setMinProblem(false); //Make a maximization problem of this Lineair Problem
        double firstResult = lpw.solve().getObjectiveValue(); //Check the result first without adding the check condition
        holdsLikelihood = sumOfPriorityValues - firstResult; //Set the new holdsLikelihood
        
        LPWizard lpw2 = new LPWizard(); //Create a new Lineair Problem
        for (int i = 0; i < holds.size(); i++) { //Loop through all Prioritized Conditions that hold
            PrioritizedCondition pc = holds.get(i);
            pc.addHoldCondition(lpw2, counter, i); //Add this Prioritized Conditions to the Lineair Problem
        }
        check.getPCLO_Implementation().setCheckCondition(lpw2, counter); //Add the check condition
        setAllToBoolean(lpw2, holds); //Set all lineair optimization variables to booleans
        lpw2.setMinProblem(false); //Make a maximization problem of this Lineair Problem
        double secondResult = lpw2.solve().getObjectiveValue(); //Check the result with adding the check condition
        int decrementScore = (int) Math.round(4.0 * (firstResult - secondResult)); //The integer which will decrease the likelihood
        return Math.max(100 - decrementScore, 0); //Return the likelihood score of the check condition
    }
    
    private void setAllToBoolean(LPWizard lpw, List<PrioritizedCondition> holds) {
        for (Player p : players) {
            for(Role r : new AllRoles().getRoles()) {
                lpw.setBoolean("RS" + p.getId() + "R" + r.toString());
            }
        }
        for (StartCategory sc : startCategories) {
            for (Role r : new AllRoles().getRoles()) {
                lpw.setBoolean("RS" + sc.getId() + "R" + r.toString());
            }
        }
        for (int i = 0; i < holds.size(); i++) {
            lpw.setBoolean("Condition" + i);
        }
    }
}
