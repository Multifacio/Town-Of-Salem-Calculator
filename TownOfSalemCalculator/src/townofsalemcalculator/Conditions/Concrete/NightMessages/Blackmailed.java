package townofsalemcalculator.Conditions.Concrete.NightMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.Conditions.Abstract.AdvancedConditions.MinimumRoleAmount;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.StartCategory;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Blackmailer;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that you were blackmailed
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-28
 */
public class Blackmailed implements Condition {
    private final List<StartCategory> startCategories;
    
    public Blackmailed(List<StartCategory> startCategories) {
        this.startCategories = startCategories;
    }
    
    @Override
    public String getCondition() {
        return "Someone threatened to reveal your secrets. You were blackmailed";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"BMed", "Blackmailed", "Threatened", "Reveal", "Secrets", "Your"});
        keyWords.addAll(Blackmailer.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new MinimumRoleAmount(startCategories, new StandardInclude(new SingleRoleGroup(Blackmailer), amnesiacTurnedInto), 1); 
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
