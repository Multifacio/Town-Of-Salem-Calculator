package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Vigilante;

/**
 * The Concrete Condition that a Vigilante has killed someone
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-29
 */
public class VigilanteKill extends KillMessage {
    public VigilanteKill() {
        super(Vigilante);
    }
    
    @Override
    public String getCondition() {
        return "He was shot by a Vigilante.";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"He", "Died", "Killed", "Death", "Shot", "Shoot"});
        keyWords.addAll(Vigilante.getKeyWords());
        return keyWords;
    }

}
