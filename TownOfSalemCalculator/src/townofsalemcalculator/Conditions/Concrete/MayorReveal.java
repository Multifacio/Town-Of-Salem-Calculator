package townofsalemcalculator.Conditions.Concrete;

import java.util.Arrays;
import java.util.List;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupCondition;
import townofsalemcalculator.Conditions.Condition;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.ClueGroup.RoleAddGroup.StandardInclude;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Player;
import static townofsalemcalculator.Role.Mayor;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;

/**
 * The Concrete Condition that someone has reveal itself as the Mayor
 * @author Multifacio
 * @version 1.1
 * @since 2017-1-26
 */
public class MayorReveal implements SearchableCondition {
    private final Player player;
    
    public MayorReveal(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "has revealed itself as the Mayor";
    }

    @Override
    public List<String> keyWords() {
        List<String> keyWords = Arrays.asList(new String[]{"Revealed", "Role", "Known"});
        keyWords.addAll(Mayor.getKeyWords());
        keyWords.add(Integer.toString(player.getPosition()));
        keyWords.add(player.getUsername());
        return keyWords;
    }

    @Override
    public void useCondition(SimulationRun sr) {
        RoleGroup rg = new StandardInclude(new SingleRoleGroup(Mayor), sr.amnesiacDetermine);
        Condition con = new PlayerIsRoleGroupCondition(player, rg);
        con.useCondition(sr);
    }
}
