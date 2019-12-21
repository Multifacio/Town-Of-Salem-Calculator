package townofsalemcalculator.Conditions.Concrete;

import java.util.Arrays;
import java.util.List;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupCondition;
import townofsalemcalculator.Conditions.Condition;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.KillingClueGroup.DeathClueGroup;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;

/**
 * The Concrete Condition that someone dies and therefore his role becomes known
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-25
 */
public class RoleKnownByDeath implements Condition, SearchableCondition {
    private final Player player;
    private final Role role;
    
    public RoleKnownByDeath(Player player, Role role) {
        this.player = player;
        this.role = role;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "died and his role was " + role.toString();
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Died", "Lynched", "Killed", "Death", "Committing", "Suicide", "Role", "Known"});
        keyWords.addAll(role.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup rg = new DeathClueGroup(role, sr.amnesiacDetermine);
        Condition con = new PlayerIsRoleGroupCondition(player, rg);
        con.useCondition(sr);
    }
}
