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
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Mafioso;
import static townofsalemcalculator.Role.Veteran;
import static townofsalemcalculator.Role.Vigilante;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueSurvivorVampireHunterAmnesiac;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueVigilanteVeteranMafioso;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Vigilante, Veteran or Mafioso
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-12
 */
public class ConcreteConditionInvestigatorVigilanteVeteranMafioso implements ConcreteCondition {
    private final Player player;
    
    public ConcreteConditionInvestigatorVigilanteVeteranMafioso(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target owns weapons. They could be the Vigilante, Veteran or Mafioso";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Owns", "Weapons", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Vigilante.getKeyWords());
        keyWords.addAll(Veteran.getKeyWords());
        keyWords.addAll(Mafioso.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueVigilanteVeteranMafioso(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    } 
}
