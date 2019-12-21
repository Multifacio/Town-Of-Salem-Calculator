package townofsalemcalculator.Conditions.Abstract.InheritConditions;

import java.util.Set;
import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Player Is Role Group Condition is that a player is a role inside a role group
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-22
 */
public class PlayerIsRoleGroupCondition implements Condition {
    private final Player player;
    private final RoleGroup roleGroup; 
    
    public PlayerIsRoleGroupCondition(Player player, RoleGroup roleGroup) {
        this.player = player;
        this.roleGroup = roleGroup;
    }
    
    @Override
    public void useCondition(SimulationRun sr) {
        int playerNum = player.getPosition() - 1;
        Set<Role> roles = roleGroup.getRoles();
        BoolVar[] vars = new BoolVar[roles.size()];
        int i = 0;
        for (Role r : roles) {
           int roleNum = r.ordinal();
           vars[i] = sr.playerRole[playerNum][roleNum];
           i++; 
        }
        sr.model.sum(vars, "=", 1).post();
    }

}
