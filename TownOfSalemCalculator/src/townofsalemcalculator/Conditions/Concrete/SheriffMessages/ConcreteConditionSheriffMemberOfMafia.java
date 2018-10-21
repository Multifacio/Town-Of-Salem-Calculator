package townofsalemcalculator.Conditions.Concrete.SheriffMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Sheriff;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.SheriffClueGroup.SheriffMemberOfMafiaClueGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.SHERIFF_MEMBER_OF_MAFIA_PRIORITY;
import townofsalemcalculator.Conditions.Condition;

/**
 * The Concrete Condition that the Sheriff sees that someone came up as a member of the mafia
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionSheriffMemberOfMafia implements Condition {
    private final Player player;
    
    public ConcreteConditionSheriffMemberOfMafia(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target is a member of the Mafia!";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Member", "Mafia", "Interrogate"});
        keyWords.addAll(Sheriff.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new SheriffMemberOfMafiaClueGroup(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, SHERIFF_MEMBER_OF_MAFIA_PRIORITY.getValue());
    }
    
}
