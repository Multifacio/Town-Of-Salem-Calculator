package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Veteran;

/**
 * The Concrete Condition that a Veteran has killed someone
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-29
 */
public class VeteranKill extends KillMessage {
    public VeteranKill() {
        super(Veteran);
    }
    
    @Override
    public String getCondition() {
        return "He was killed by a Veteran.";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"He", "Died", "Killed", "Death", "Shot", "Shoot"});
        keyWords.addAll(Veteran.getKeyWords());
        return keyWords;
    }
}
