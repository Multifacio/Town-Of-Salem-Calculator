package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Consigliere;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Mayor;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Investigator, Consigliere or Mayor
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-11
 */
public class InvestigatorClueInvestigatorConsigliereMayor extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueInvestigatorConsigliereMayor(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() +  "Your target has sensitive information to reveal. They could be the Investigator, "
                + "Consigliere or Mayor";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Sensitive", "Information", "Reveal", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Consigliere.getKeyWords());
        keyWords.addAll(Mayor.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Investigator));
            addRoleGroup(new SingleRoleGroup(Consigliere));
            addRoleGroup(new SingleRoleGroup(Mayor));
        }
    }
}
