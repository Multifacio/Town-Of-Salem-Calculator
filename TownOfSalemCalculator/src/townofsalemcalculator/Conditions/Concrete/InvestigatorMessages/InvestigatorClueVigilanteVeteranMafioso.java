package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Mafioso;
import static townofsalemcalculator.Role.Veteran;
import static townofsalemcalculator.Role.Vigilante;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Vigilante, Veteran or Mafioso
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class InvestigatorClueVigilanteVeteranMafioso extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueVigilanteVeteranMafioso(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target owns weapons. They could be the Vigilante, Veteran or Mafioso";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Owns", "Weapons", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Vigilante.getKeyWords());
        keyWords.addAll(Veteran.getKeyWords());
        keyWords.addAll(Mafioso.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }
 
    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Vigilante));
            addRoleGroup(new SingleRoleGroup(Veteran));
            addRoleGroup(new SingleRoleGroup(Mafioso));
        }
    }
}
