package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.SerialKiller;

/**
 * The Concrete Condition that a Serial Killer has killed someone
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-10
 */
public class SerialKillerKill extends KillMessage {
    public SerialKillerKill() {
        super(SerialKiller);
    }
    
    @Override
    public String getCondition() {
        return "He was stabbed by a Serial Killer";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"He", "Died", "Killed", "Death", "Stabbed"});
        keyWords.addAll(SerialKiller.getKeyWords());
        return keyWords;
    }
}
