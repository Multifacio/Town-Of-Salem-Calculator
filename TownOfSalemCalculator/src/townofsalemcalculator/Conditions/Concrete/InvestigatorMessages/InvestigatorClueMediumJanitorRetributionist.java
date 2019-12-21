package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Janitor;
import static townofsalemcalculator.Role.Medium;
import static townofsalemcalculator.Role.Retributionist;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import static townofsalemcalculator.Role.Investigator;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Medium, Janitor or Retributionist
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class InvestigatorClueMediumJanitorRetributionist extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueMediumJanitorRetributionist(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target works with dead bodies. They could be the Medium, Janitor or Retributionist";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Works", "Dead", "Bodies", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Medium.getKeyWords());
        keyWords.addAll(Janitor.getKeyWords());
        keyWords.addAll(Retributionist.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }
    
    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Medium));
            addRoleGroup(new SingleRoleGroup(Janitor));
            addRoleGroup(new SingleRoleGroup(Retributionist));
        }
    }
}
