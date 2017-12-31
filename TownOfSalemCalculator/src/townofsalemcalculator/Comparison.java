package townofsalemcalculator;

/**
 * A Comparison is used for equalities and inequalities
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public enum Comparison {    
    LesserOrEqual("<="),
    Equal("="),
    GreaterOrEqual(">=");
    
    static {
        LesserOrEqual.oppositeComparison = GreaterOrEqual;
        Equal.oppositeComparison = Equal;
        GreaterOrEqual.oppositeComparison = LesserOrEqual;
    }
    
    private final String comparisonOperator; //The symbol which is used for this comparison
    private static Comparison oppositeComparison; //The comparison which is opposite of this comparison
    
    Comparison(String comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }
    
    /**
     * Get the symbol used for this comparison
     * @return The symbol used for this comparison
     */
    public String getComparisonOperator() {
        return comparisonOperator;
    }
    
    public Comparison getOppositeComparison() {
        return oppositeComparison;
    }
}
