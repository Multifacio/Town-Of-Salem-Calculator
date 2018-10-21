package townofsalemcalculator.Conditions;

/**
 * A Searchable is a class that can be searched by keywords
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-20
 */
public interface Searchable {
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
}
