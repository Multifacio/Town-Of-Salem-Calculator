package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Arsonist;

/**
 * The Concrete Condition that an Arsonist has killed someone
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-10
 */
public class ArsonistKill extends KillMessage {
    public ArsonistKill() {
        super(Arsonist);
    }
    
    @Override
    public String getCondition() {
        return "He was incinerated by an Arsonist";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"He", "Died", "Killed", "Death", "Incinerated", "Ignited", "Doused"});
        keyWords.addAll(Arsonist.getKeyWords());
        return keyWords;
    }
}
