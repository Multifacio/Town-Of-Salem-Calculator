package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Blackmailer;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Jailor;
import static townofsalemcalculator.Role.Spy;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Spy, Blackmailer or Jailor
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class InvestigatorClueSpyBlackmailerJailor extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueSpyBlackmailerJailor(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target knows your darkest secrets. They could be the Spy, Blackmailer or Jailor";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Knows", "Darkest", "Secrets", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Spy.getKeyWords());
        keyWords.addAll(Blackmailer.getKeyWords());
        keyWords.addAll(Jailor.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }
    
    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Spy));
            addRoleGroup(new SingleRoleGroup(Blackmailer));
            addRoleGroup(new SingleRoleGroup(Jailor));
        }
    }
}
