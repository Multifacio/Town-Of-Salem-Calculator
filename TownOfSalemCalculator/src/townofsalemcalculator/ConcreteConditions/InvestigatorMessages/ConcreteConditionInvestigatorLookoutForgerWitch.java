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
import static townofsalemcalculator.Role.Forger;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Lookout;
import static townofsalemcalculator.Role.Witch;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueLookoutForgerWitch;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Lookout, Forger or Witch
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionInvestigatorLookoutForgerWitch implements ConcreteCondition {
    private final Player player;
    
    public ConcreteConditionInvestigatorLookoutForgerWitch(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target sticks to the shadows. They could be the Lookout, Forger or Witch";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Sticks", "Shadows", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Lookout.getKeyWords());
        keyWords.addAll(Forger.getKeyWords());
        keyWords.addAll(Witch.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueLookoutForgerWitch(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    }
    
}
