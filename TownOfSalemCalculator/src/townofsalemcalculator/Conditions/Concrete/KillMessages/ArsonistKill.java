package townofsalemcalculator.Conditions.Concrete.KillMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.MinimumRoleAmount;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Arsonist;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that an Arsonist has killed someone
 * @author Multifacio
 * @version 1.0
 * @since 2017-2-10
 */
public class ArsonistKill implements Condition {
    private final List<StartCategory> startCategories;
    
    public ArsonistKill(List<StartCategory> startCategories) {
        this.startCategories = startCategories;
    }
    
    @Override
    public String getCondition() {
        return "He was incinerated by an Arsonist";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"He", "Died", "Killed", "Death", "Incinerated", "Ignited", "Doused"});
        keyWords.addAll(Arsonist.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new MinimumRoleAmount(startCategories, new StandardInclude(new SingleRoleGroup(Arsonist), amnesiacTurnedInto), 1); 
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
