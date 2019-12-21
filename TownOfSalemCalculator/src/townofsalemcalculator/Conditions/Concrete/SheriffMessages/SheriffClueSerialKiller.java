package townofsalemcalculator.Conditions.Concrete.SheriffMessages;

import java.util.Arrays;
import java.util.List;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupOrRoleExistenceCondition;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Sheriff;
import townofsalemcalculator.Conditions.Condition;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import static townofsalemcalculator.Role.SerialKiller;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;

/**
 * The Concrete Condition that the Sheriff sees that someone came up as a Serial Killer
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class SheriffClueSerialKiller implements Condition, SearchableCondition {
    private final Player player;
    
    public SheriffClueSerialKiller(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target is a Serial Killer!";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Interrogate"});
        keyWords.addAll(Sheriff.getKeyWords());
        keyWords.addAll(SerialKiller.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup disturbGroup = new StandardInclude(new SingleRoleGroup(Transporter), sr.amnesiacDetermine);
        RoleGroup suspiciousGroup = new StandardInclude(new SingleRoleGroup(SerialKiller), sr.amnesiacDetermine);
        Condition condition = new PlayerIsRoleGroupOrRoleExistenceCondition(player, suspiciousGroup, disturbGroup);
        condition.useCondition(sr);
    }    
}


