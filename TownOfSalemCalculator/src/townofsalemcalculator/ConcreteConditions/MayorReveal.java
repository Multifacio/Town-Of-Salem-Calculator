package townofsalemcalculator.ConcreteConditions;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.Mayor;
import townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that someone has reveal itself as the Mayor
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-26
 */
public class MayorReveal implements ConcreteCondition {
    private final Player player;
    
    public MayorReveal(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return player.getPosition() + ": " + player.getUsername() + " has revealed itself as the Mayor";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Revealed", "Role", "Known",
        Integer.toString(player.getPosition()), player.getUsername()});
        keyWords.addAll(Mayor.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        //The condition which needs to hold
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new StandardInclude(new SingleRoleGroup(Mayor), amnesiacTurnedInto)); 
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
