package townofsalemcalculator.ConcreteConditions.KillMessages;

import townofsalemcalculator.ConcreteConditions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.MinimumRoleAmount;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Janitor;
import static townofsalemcalculator.Role.Vigilante;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that someone was cleaned while he was killed
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-10
 */
public class Cleaned implements ConcreteCondition {
    private final List<StartCategory> startCategories;
    
    public Cleaned(List<StartCategory> startCategories) {
        this.startCategories = startCategories;
    }
    
    @Override
    public String getCondition() {
        return "Someone was cleaned (we could not determine its role)";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"We", "Could", "Not", "Determine", "Role", "Cleaned"});
        keyWords.addAll(Janitor.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new MinimumRoleAmount(startCategories, new StandardInclude(new SingleRoleGroup(Vigilante), amnesiacTurnedInto), 1); 
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
