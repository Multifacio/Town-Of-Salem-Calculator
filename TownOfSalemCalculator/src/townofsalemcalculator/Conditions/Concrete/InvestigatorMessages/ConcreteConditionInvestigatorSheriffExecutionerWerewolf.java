package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Executioner;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Sheriff;
import static townofsalemcalculator.Role.Werewolf;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueSheriffExecutionerWerewolf;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;
import townofsalemcalculator.Conditions.Condition;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Sheriff, Executioner or Werewolf
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionInvestigatorSheriffExecutionerWerewolf implements Condition {
    private final Player player;
    
    public ConcreteConditionInvestigatorSheriffExecutionerWerewolf(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target is waiting for the perfect moment to strike. They could be the Sheriff, Executioner or Werewolf";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Waiting", "Perfect", "Moment", "Strike", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Sheriff.getKeyWords());
        keyWords.addAll(Executioner.getKeyWords());
        keyWords.addAll(Werewolf.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueSheriffExecutionerWerewolf(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    } 
}
