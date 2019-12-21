package townofsalemcalculator.Conditions.Concrete;

import java.util.Arrays;
import java.util.List;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Amnesiac;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;

/**
 * The Concrete Condition that an Amnesiac remembered who he was
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-25
 */
public class AmnesiacRemembered implements SearchableCondition {
    private final Role role;
    
    public AmnesiacRemembered(Role role) {
        this.role = role;
    }
    
    @Override
    public String getCondition() {
        return "An Amnesiac remembered that they were " + role.toString();
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Remembered"});
        keyWords.addAll(role.getKeyWords());
        keyWords.addAll(Amnesiac.getKeyWords());
        return keyWords;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        sr.amnesiacDetermine.add(role);
    }
}
