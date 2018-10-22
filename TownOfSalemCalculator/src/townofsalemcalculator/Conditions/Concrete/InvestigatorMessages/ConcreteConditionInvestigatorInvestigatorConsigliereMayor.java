package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Consigliere;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Mayor;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueInvestigatorConsigliereMayor;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;
import townofsalemcalculator.Conditions.Condition;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Investigator, Consigliere or Mayor
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-11
 */
public class ConcreteConditionInvestigatorInvestigatorConsigliereMayor implements Condition{
    private final Player player;
    
    public ConcreteConditionInvestigatorInvestigatorConsigliereMayor(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target has sensitive information to reveal. They could be the Investigator, Consigliere or Mayor";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Sensitive", "Information", "Reveal", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Consigliere.getKeyWords());
        keyWords.addAll(Mayor.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueInvestigatorConsigliereMayor(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    }
    
}
