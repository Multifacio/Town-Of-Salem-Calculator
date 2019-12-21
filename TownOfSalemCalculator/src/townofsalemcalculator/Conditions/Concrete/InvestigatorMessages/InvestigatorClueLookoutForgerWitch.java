package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Forger;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Lookout;
import static townofsalemcalculator.Role.Witch;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Lookout, Forger or Witch
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class InvestigatorClueLookoutForgerWitch extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueLookoutForgerWitch(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() +  "Your target sticks to the shadows. They could be the Lookout, Forger or Witch";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Sticks", "Shadows", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Lookout.getKeyWords());
        keyWords.addAll(Forger.getKeyWords());
        keyWords.addAll(Witch.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Lookout));
            addRoleGroup(new SingleRoleGroup(Forger));
            addRoleGroup(new SingleRoleGroup(Witch));
        }
    }
}
