package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Witch;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that you were witched
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-28
 */
public class Witched extends NightMessage {
    
    public Witched() {
        super(new SingleRoleGroup(Witch));
    }
    
    @Override
    public String getCondition() {
        return "You feel a mystical power dominating you. You were controlled by a Witch!";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Feel", "Mystical", "Power", "Dominating", "Controlled", "Witched", "You"});
        keyWords.addAll(Witch.getKeyWords());
        return keyWords;
    }
}
