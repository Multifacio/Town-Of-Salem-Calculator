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
import static townofsalemcalculator.Role.Amnesiac;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Survivor;
import static townofsalemcalculator.Role.VampireHunter;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueSurvivorVampireHunterAmnesiac;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Survivor, Vampire Hunter or Amnesiac
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionInvestigatorSurvivorVampireHunterAmnesiac implements ConcreteCondition {
    private final Player player;
    
    public ConcreteConditionInvestigatorSurvivorVampireHunterAmnesiac(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target keeps to themselves. They could be the Survivor, Vampire Hunter or Amnesiac";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Keeps", "Themselves", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Survivor.getKeyWords());
        keyWords.addAll(VampireHunter.getKeyWords());
        keyWords.addAll(Amnesiac.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueSurvivorVampireHunterAmnesiac(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    } 
}
