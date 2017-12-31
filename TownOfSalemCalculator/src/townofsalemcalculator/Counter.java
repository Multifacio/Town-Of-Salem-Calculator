package townofsalemcalculator;

/**
 * A Counter will count the calls to the increment method
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-31
 */
public class Counter {
    private int counter;
    
    public Counter() {
        counter = 0;
    }
    
    public int getCounterValue() {
        return counter;
    }
    
    public void increment() {
        counter++;
    }
}
