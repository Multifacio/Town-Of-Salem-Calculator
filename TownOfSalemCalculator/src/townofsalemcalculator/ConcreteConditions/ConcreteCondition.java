package townofsalemcalculator.ConcreteConditions;

import java.util.Set;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;

/**
 * A Concrete Condition is a statement about the game
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-5
 */
public interface ConcreteCondition {
    /**
     * Get the condition explained
     * @return The explanation of the condition
     */
    public String getCondition();
    
    /**
     * Get the key words which can be searched for
     * @return The key words that belong to this condition
     */
    public String[] keyWords();
    
    /**
     * Convert the condition to the corresponding Prioritized Condition
     * @param previousConditions All concrete conditions that already have been executed
     * @return The Prioritized Condition that belongs to this Concrete Condition
     */
    public PrioritizedCondition getPrioritizedCondition(Set<ConcreteCondition> previousConditions);
}
