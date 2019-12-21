package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Executioner;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Sheriff;
import static townofsalemcalculator.Role.Werewolf;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Sheriff, Executioner or Werewolf
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class InvestigatorClueSheriffExecutionerWerewolf extends InvestigatorClue {
    private final Player player;
     
    public InvestigatorClueSheriffExecutionerWerewolf(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target is waiting for the perfect moment to strike. They could be the Sheriff, "
                + "Executioner or Werewolf";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Waiting", "Perfect", "Moment", "Strike", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Sheriff.getKeyWords());
        keyWords.addAll(Executioner.getKeyWords());
        keyWords.addAll(Werewolf.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }
    
    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Sheriff));
            addRoleGroup(new SingleRoleGroup(Executioner));
            addRoleGroup(new SingleRoleGroup(Werewolf));
        }
    }
}
