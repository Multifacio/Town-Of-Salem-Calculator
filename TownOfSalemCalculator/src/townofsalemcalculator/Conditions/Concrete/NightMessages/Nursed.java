package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Role.Doctor;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that you were healed
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-28
 */
public class Nursed extends NightMessage {    
    public Nursed() {
        super(new SingleRoleGroup(Doctor));
    }
    
    @Override
    public String getCondition() {
        return "You were attacked but someone nursed you back to health";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Attacked", "Nursed", "Back", "Health", "Healed", "You"});
        keyWords.addAll(Doctor.getKeyWords());
        return keyWords;
    }
}
