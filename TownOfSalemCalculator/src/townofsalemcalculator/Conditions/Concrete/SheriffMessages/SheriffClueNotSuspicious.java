package townofsalemcalculator.Conditions.Concrete.SheriffMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupOrRoleExistenceCondition;
import townofsalemcalculator.Conditions.Concrete.SheriffMessages.SheriffClueMemberOfMafia.MafiaExceptGodfather;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Sheriff;
import townofsalemcalculator.Conditions.Condition;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.SerialKiller;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;

/**
 * The Concrete Condition that the Sheriff sees that someone is not suspicious. 
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-02
 */
public class SheriffClueNotSuspicious implements SearchableCondition {
    private final Player player;
    
    public SheriffClueNotSuspicious(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target is not suspicious";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Not", "Suspicious", "Interrogate"});
        keyWords.addAll(Sheriff.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup disturbGroup = new StandardInclude(new SingleRoleGroup(Transporter), sr.amnesiacDetermine);
        RoleGroup suspiciousGroup = new NotSuspiciousInclusive(sr.amnesiacDetermine);
        Condition condition = new PlayerIsRoleGroupOrRoleExistenceCondition(player, suspiciousGroup, disturbGroup);
        condition.useCondition(sr);
    }

    static class NotSuspiciousInclusive extends StandardInclude {
        public NotSuspiciousInclusive(Set<Role> amnesiacDetermine) {
            super(new NotSuspicious(), amnesiacDetermine);
        }
        
        static class NotSuspicious extends CompositeRoleGroup {
            public NotSuspicious() {
                addRoleGroup(new MafiaExceptGodfather());
                addRoleGroup(new SingleRoleGroup(SerialKiller));
            }
        }
    }
}
