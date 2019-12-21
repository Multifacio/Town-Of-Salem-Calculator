package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Escort;

/**
 * The Concrete Condition that you were roleblocked
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-28
 */
public class Roleblocked extends NightMessage {
    
    public Roleblocked() {
        super(new RoleBlockerGroup());
    }
    
    @Override
    public String getCondition() {
        return "Someone occupied your night. You were role blocked";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Rbed", "Roleblocked", "Role", "Blocked", "Occupied", "You", "Someone"});
        keyWords.addAll(Escort.getKeyWords());
        keyWords.addAll(Consort.getKeyWords());
        return keyWords;
    }
    
    static class RoleBlockerGroup extends CompositeRoleGroup {    
        public RoleBlockerGroup() {
            addRoleGroup(new townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup(Escort));
            addRoleGroup(new townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup(Consort));
        }
    }
}
