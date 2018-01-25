package townofsalemcalculator.Simulations.PCLO_Simulation;

public enum PriorityValues {
    TOP_PRIORITY(10000.0);
    
    private final double value;
    
    PriorityValues(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
}
