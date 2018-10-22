package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Blackmailer;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Jailor;
import static townofsalemcalculator.Role.Spy;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueSpyBlackmailerJailor;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;
import townofsalemcalculator.Conditions.Condition;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Spy, Blackmailer or Jailor
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionInvestigatorSpyBlackmailerJailor implements Condition {
    private final Player player;
    
    public ConcreteConditionInvestigatorSpyBlackmailerJailor(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target knows your darkest secrets. They could be the Spy, Blackmailer or Jailor";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Knows", "Darkest", "Secrets", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Spy.getKeyWords());
        keyWords.addAll(Blackmailer.getKeyWords());
        keyWords.addAll(Jailor.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueSpyBlackmailerJailor(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    } 
}
