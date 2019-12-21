package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Escort;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Escort, Transporter or Consort
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-11
 */
public class InvestigatorClueEscortTransporterConsort extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueEscortTransporterConsort(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target is skilled at disrupting others. They could be the Escort, Transporter or Consort";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Skilled", "Disrupting", "Others", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Escort.getKeyWords());
        keyWords.addAll(Transporter.getKeyWords());
        keyWords.addAll(Consort.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Escort));
            addRoleGroup(new SingleRoleGroup(Transporter));
            addRoleGroup(new SingleRoleGroup(Consort));
        }
    }
}
