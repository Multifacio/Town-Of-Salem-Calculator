package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Investigator;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import static townofsalemcalculator.Role.Disguiser;
import static townofsalemcalculator.Role.Doctor;
import static townofsalemcalculator.Role.SerialKiller;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Doctor, Disguiser or Serial Killer
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-10
 */
public class InvestigatorClueDoctorDisguiserSerialKiller extends InvestigatorClue {
    private final Player player;
    
    public InvestigatorClueDoctorDisguiserSerialKiller(Player player) {
        super(player, new InvestigatorClueGroup());
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target is covered in blood. They could be the Doctor, Disguiser or Serial Killer";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Covered", "Blood", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Doctor.getKeyWords());
        keyWords.addAll(Disguiser.getKeyWords());
        keyWords.addAll(SerialKiller.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }
    
    static class InvestigatorClueGroup extends CompositeRoleGroup {
        public InvestigatorClueGroup() {
            addRoleGroup(new SingleRoleGroup(Doctor));
            addRoleGroup(new SingleRoleGroup(Disguiser));
            addRoleGroup(new SingleRoleGroup(SerialKiller));
        }
    }
}
