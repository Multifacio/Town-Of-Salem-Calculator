package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Blackmailer;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that you were blackmailed
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-28
 */
public class Blackmailed extends NightMessage {
    public Blackmailed() {
        super(new SingleRoleGroup(Blackmailer));
    }
    
    @Override
    public String getCondition() {
        return "Someone threatened to reveal your secrets. You were blackmailed";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"BMed", "Blackmailed", "Threatened", "Reveal", "Secrets", "Your"});
        keyWords.addAll(Blackmailer.getKeyWords());
        return keyWords;
    }
}
