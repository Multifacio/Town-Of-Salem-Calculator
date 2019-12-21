package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Werewolf;

/**
 * The Concrete Condition that a Werewolf has killed someone
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-10
 */
public class WerewolfKill extends KillMessage {
    public WerewolfKill() {
        super(Werewolf);
    }
    
    @Override
    public String getCondition() {
        return "He was mauled by a Werewolf";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"He", "Died", "Killed", "Death", "Mauled"});
        keyWords.addAll(Werewolf.getKeyWords());
        return keyWords;
    }
}
