package townofsalemcalculator.Simulations.PCLO_Simulation;

//Priority Values can be obtained by the folowing formula: -4 * Ln(A), where A is the probability that the statement is not true.
public enum PriorityValues {
    TOP_PRIORITY(10000.0),
    INVESTIGATOR_NORMAL_PRIORITY(12.0),
    INVESTIGATOR_FRAMER_PRIORITY(10.5),
    SHERIFF_MEMBER_OF_MAFIA_PRIORITY(10.5),
    SHERIFF_OTHER_PRIORITY(12.0);
    
    private final double value;
    
    PriorityValues(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
}


