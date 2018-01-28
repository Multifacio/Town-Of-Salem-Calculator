package townofsalemcalculator.ConcreteConditions.NightMessages;

import townofsalemcalculator.ConcreteConditions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.MinimumRoleAmount;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Escort;
import townofsalemcalculator.RoleGroup.ClueGroup.JailorEscortClueGroup.RoleBlockerClueGroup;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that you were roleblocked
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-28
 */
public class Roleblocked implements ConcreteCondition {
    private final List<StartCategory> startCategories;
    
    public Roleblocked(List<StartCategory> startCategories) {
        this.startCategories = startCategories;
    }
    
    @Override
    public String getCondition() {
        return "Someone occupied your night. You were role blocked";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Rbed", "Roleblocked", "Role", "Blocked", "Occupied", "You", "Someone"});
        keyWords.addAll(Escort.getKeyWords());
        keyWords.addAll(Consort.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        AbstractCondition hold = new MinimumRoleAmount(startCategories, new RoleBlockerClueGroup(amnesiacTurnedInto), 1); //The condition which needs to hold
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
