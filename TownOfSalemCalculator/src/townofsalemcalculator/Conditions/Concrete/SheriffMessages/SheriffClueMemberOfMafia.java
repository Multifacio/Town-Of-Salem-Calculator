package townofsalemcalculator.Conditions.Concrete.SheriffMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupOrRoleExistenceCondition;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Sheriff;
import townofsalemcalculator.Conditions.Condition;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Framer;
import static townofsalemcalculator.Role.Godfather;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;

/**
 * The Concrete Condition that the Sheriff sees that someone came up as a member of the mafia
 * @author Multifacio
 * @version 1.1
 * @since 2017-2-12
 */
public class SheriffClueMemberOfMafia implements SearchableCondition {
    private final Player player;
    
    public SheriffClueMemberOfMafia(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "Your target is a member of the Mafia!";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Member", "Mafia", "Interrogate"});
        keyWords.addAll(Sheriff.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup disturbGroup = new SheriffSuspiciousDisturbersInclude(sr.amnesiacDetermine);
        RoleGroup suspiciousGroup = new MafiaExceptGodfatherInclusive(sr.amnesiacDetermine);
        Condition condition = new PlayerIsRoleGroupOrRoleExistenceCondition(player, suspiciousGroup, disturbGroup);
        condition.useCondition(sr);
    }    
    
    static class SheriffSuspiciousDisturbersInclude extends StandardInclude {
        public SheriffSuspiciousDisturbersInclude(Set<Role> amnesiacDetermine) {
            super(new SheriffSuspiciousDisturbers(), amnesiacDetermine);
        }
        
        static class SheriffSuspiciousDisturbers extends CompositeRoleGroup {
            public SheriffSuspiciousDisturbers() {
                addRoleGroup(new SingleRoleGroup(Framer));
                addRoleGroup(new SingleRoleGroup(Transporter));
            }
        }
    }
    
    static class MafiaExceptGodfatherInclusive extends StandardInclude {   
        public MafiaExceptGodfatherInclusive(Set<Role> amnesiacDetermine) {
            super(new MafiaExceptGodfather(), amnesiacDetermine);
        }
    }
    
    static class MafiaExceptGodfather extends DifferenceRoleGroup {
        public MafiaExceptGodfather() {
            super(new MafiaGroupNonCoven(), new SingleRoleGroup(Godfather));
        }
    }
}


