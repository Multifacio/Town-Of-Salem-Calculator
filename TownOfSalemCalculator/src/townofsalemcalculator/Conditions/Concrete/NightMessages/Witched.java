package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.MinimumRoleAmount;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Witch;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that you were witched
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-28
 */
public class Witched implements Condition {
    private final List<StartCategory> startCategories;
    
    public Witched(List<StartCategory> startCategories) {
        this.startCategories = startCategories;
    }
    
    @Override
    public String getCondition() {
        return "You feel a mystical power dominating you. You were controlled by a Witch!";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Feel", "Mystical", "Power", "Dominating", "Controlled", "Witched", "You"});
        keyWords.addAll(Witch.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new MinimumRoleAmount(startCategories, new StandardInclude(new SingleRoleGroup(Witch), amnesiacTurnedInto), 1); 
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
