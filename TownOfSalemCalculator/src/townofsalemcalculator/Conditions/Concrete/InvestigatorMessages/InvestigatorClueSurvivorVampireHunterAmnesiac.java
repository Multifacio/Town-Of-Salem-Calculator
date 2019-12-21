package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Amnesiac;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Survivor;
import static townofsalemcalculator.Role.VampireHunter;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Survivor, Vampire Hunter or Amnesiac
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class InvestigatorClueSurvivorVampireHunterAmnesiac extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueSurvivorVampireHunterAmnesiac(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target keeps to themselves. They could be the Survivor, Vampire Hunter or Amnesiac";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Keeps", "Themselves", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Survivor.getKeyWords());
        keyWords.addAll(VampireHunter.getKeyWords());
        keyWords.addAll(Amnesiac.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }
    
    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Survivor));
            addRoleGroup(new SingleRoleGroup(VampireHunter));
            addRoleGroup(new SingleRoleGroup(Amnesiac));
        }
    }
}
