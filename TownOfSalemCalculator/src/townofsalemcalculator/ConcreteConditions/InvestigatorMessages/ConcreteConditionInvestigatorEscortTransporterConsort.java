package townofsalemcalculator.ConcreteConditions.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.ConcreteConditions.ConcreteCondition;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Escort;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Transporter;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueEscortTransporterConsort;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Escort, Transporter or Consort
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-11
 */
public class ConcreteConditionInvestigatorEscortTransporterConsort implements ConcreteCondition{
    private final Player player;
    
    public ConcreteConditionInvestigatorEscortTransporterConsort(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target is skilled at disrupting others. They could be the Escort, Transporter or Consort";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Skilled", "Disrupting", "Others", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Escort.getKeyWords());
        keyWords.addAll(Transporter.getKeyWords());
        keyWords.addAll(Consort.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueEscortTransporterConsort(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    }
    
}
