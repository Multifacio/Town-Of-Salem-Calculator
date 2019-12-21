package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Janitor;

/**
 * The Concrete Condition that someone was cleaned while he was killed
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-10
 */
public class Cleaned extends KillMessage {
    
    public Cleaned() {
        super(Janitor);
    }
    
    @Override
    public String getCondition() {
        return "Someone was cleaned (we could not determine its role)";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"We", "Could", "Not", "Determine", "Role", "Cleaned"});
        keyWords.addAll(Janitor.getKeyWords());
        return keyWords;
    }
}
