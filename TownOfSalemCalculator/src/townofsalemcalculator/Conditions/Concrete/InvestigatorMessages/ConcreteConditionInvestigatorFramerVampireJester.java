package townofsalemcalculator.Conditions.Concrete.InvestigatorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Framer;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Jester;
import static townofsalemcalculator.Role.Vampire;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueFramerVampireJester;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_FRAMER_PRIORITY;
import townofsalemcalculator.Conditions.Condition;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Framer, Vampire or Jester
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-11
 */
public class ConcreteConditionInvestigatorFramerVampireJester implements Condition {
    private final Player player;
    
    public ConcreteConditionInvestigatorFramerVampireJester(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target may not be what they seem. They could be the Framer, Vampire or Jester";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Not", "Be", "Seem", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Framer.getKeyWords());
        keyWords.addAll(Vampire.getKeyWords());
        keyWords.addAll(Jester.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueFramerVampireJester(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_FRAMER_PRIORITY.getValue());
    }
    
}
