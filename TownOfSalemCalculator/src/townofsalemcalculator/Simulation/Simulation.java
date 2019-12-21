package townofsalemcalculator.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.strategy.FullyRandom;
import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Check.Check;
import townofsalemcalculator.Conditions.Condition;

/**
 * A Simulation determines the likelyhood of a statement (Check) based on a list of statements (Conditions)
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-22
 */
public class Simulation {
    private final static int MAX_RUNS = 10000; //How often the Monte Carlo simulation is executed maximally
    private List<Condition> conditions; //The statements which the simulation has to satisfy, sorted in order when the condition is added
    
    public Simulation() {
        conditions = new ArrayList();
    }
    
    /**
     * Add a condition to the simulation
     * @param condition The constraint which the simulation has to satisfy
     */
    public void addCondition(Condition condition) {
        conditions.add(condition);
    }
    
    /**
     * Determines the likely hood of a statement
     * @param check The statement which likelyhood is checked
     * @return The probability that the statement is true (between 0.0 and 1.0). Return -1.0 if the model is infeasible (set of constraints not satisfiable)
     */
    public double likelyhoodCheck(Check check) {
        Random rand = new Random();
        SimulationRun sr = new SimulationRun();
        for (Condition c : conditions) { //Add the conditions to the Simulation Run instance
            c.useCondition(sr); 
        }
        Solver solver = sr.model.getSolver();
        BoolVar[] variables = sr.get1DimensionalVariableArray();
        solver.setSearch(new FullyRandom(variables, rand.nextLong()));
        
        //Do a Monte Carlo simulation
        int satisfyCount = 0; //How often the check statement is satisfied
        int totalCount = 0; //How often the monte carlo simulation is run
        while (solver.solve() && totalCount < MAX_RUNS) {
            if (check.satisfies(sr)) {
                satisfyCount++;
            }
            totalCount++;
        }
        if (totalCount == 0) {
            return -1.0;
        }
        else {
            return ((double) satisfyCount) / ((double) totalCount);
        }
    }
}
