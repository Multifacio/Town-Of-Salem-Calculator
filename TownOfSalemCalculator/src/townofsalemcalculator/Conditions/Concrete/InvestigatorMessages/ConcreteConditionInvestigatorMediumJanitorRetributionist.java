package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Janitor;
import static townofsalemcalculator.Role.Medium;
import static townofsalemcalculator.Role.Retributionist;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueMediumJanitorRetributionist;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;
import townofsalemcalculator.Conditions.Condition;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Medium, Janitor or Retributionist
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionInvestigatorMediumJanitorRetributionist implements Condition {
    private final Player player;
    
    public ConcreteConditionInvestigatorMediumJanitorRetributionist(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target works with dead bodies. They could be the Medium, Janitor or Retributionist";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Works", "Dead", "Bodies", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Medium.getKeyWords());
        keyWords.addAll(Janitor.getKeyWords());
        keyWords.addAll(Retributionist.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueMediumJanitorRetributionist(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    } 
}
