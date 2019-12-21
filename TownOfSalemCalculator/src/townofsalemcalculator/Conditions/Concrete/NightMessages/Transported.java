package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that you were transported
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-28
 */
public class Transported extends NightMessage {
    public Transported() {
        super(new SingleRoleGroup(Transporter));
    }
    
    @Override
    public String getCondition() {
        return "You were transported to another location";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Transported", "Transed", "Another", "Location", "You"});
        keyWords.addAll(Transporter.getKeyWords());
        return keyWords;
    }
}
