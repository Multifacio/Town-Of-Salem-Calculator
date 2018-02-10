package townofsalemcalculator.ConcreteConditions;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.AbstractConditions.AbstractCondition;
import townofsalemcalculator.AbstractConditions.AdvancedConditions.EitherRoleForRoleSelecter;
import townofsalemcalculator.Game.AmnesiacDetermine;
import townofsalemcalculator.Game.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.ClueGroup.KillingClueGroup.DeathClueGroup;
import townofsalemcalculator.Simulations.PCLO_Simulation.PrioritizedCondition;
import static townofsalemcalculator.Simulations.PCLO_Simulation.PriorityValues.TOP_PRIORITY;

/**
 * The Concrete Condition that someone dies and therefore his role becomes known
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-25
 */
public class RoleKnownByDeath implements ConcreteCondition {
    private final Player player;
    private final Role role;
    
    public RoleKnownByDeath(Player player, Role role) {
        this.player = player;
        this.role = role;
    }
    
    @Override
    public String getCondition() {
        return player.getPosition() + ": " + player.getUsername() + " died and his role was " + role.toString();
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Died", "Lynched", "Killed", "Death", "Committing", "Suicide",
        Integer.toString(player.getPosition()), player.getUsername(), "Role", "Known"});
        keyWords.addAll(role.getKeyWords());
        return keyWords;
    }

    @Override
    public PrioritizedCondition getPrioritizedCondition(List<ConcreteCondition> previousConditions) {
        Set<Role> amnesiacTurnedInto = AmnesiacDetermine.getRememberedRoles(previousConditions); //Get all roles the Amnesiac has turned into
        AbstractCondition hold = new EitherRoleForRoleSelecter(player, new DeathClueGroup(role, amnesiacTurnedInto)); //The condition which needs to hold
        return new PrioritizedCondition(hold, TOP_PRIORITY.getValue());
    }
}
