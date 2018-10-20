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
import static townofsalemcalculator.Role.Disguiser;
import static townofsalemcalculator.Role.Doctor;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.SerialKiller;
import townofsalemcalculator.RoleGroup.ClueGroup.InvestigatorClueGroup.InvestigatorClueDoctorDisguiserSerialKiller;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.INVESTIGATOR_NORMAL_PRIORITY;

/**
 * The Concrete Condition that the Investigator sees that someone came up as Doctor, Disguiser or Serial Killer
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-10
 */
public class ConcreteConditionInvestigatorDoctorDisguiserSerialKiller implements ConcreteCondition{
    private final Player player;
    
    public ConcreteConditionInvestigatorDoctorDisguiserSerialKiller(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return "Your target is covered in blood. They could be the Doctor, Disguiser or Serial Killer";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Your", "Target", "Covered", "Blood", "They"});
        keyWords.addAll(Investigator.getKeyWords());
        keyWords.addAll(Doctor.getKeyWords());
        keyWords.addAll(Disguiser.getKeyWords());
        keyWords.addAll(SerialKiller.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new InvestigatorClueDoctorDisguiserSerialKiller(amnesiacTurnedInto));
        return new PrioritizedCondition(hold, INVESTIGATOR_NORMAL_PRIORITY.getValue());
    }
    
}
