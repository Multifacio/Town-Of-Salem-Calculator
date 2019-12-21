package townofsalemcalculator.Conditions.Abstract.InheritConditions;

import java.util.Set;
import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Player Is Role Group Or Role Existence Condition is that a player is a role inside a role group or that a role of the role group must exist in the game
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-22
 */
public class PlayerIsRoleGroupOrRoleExistenceCondition implements Condition {
    private final Player player;
    private final RoleGroup roleGroup; 
    private final RoleGroup existRoleGroup;
    
    public PlayerIsRoleGroupOrRoleExistenceCondition(Player player, RoleGroup roleGroup, RoleGroup existRoleGroup) {
        this.player = player;
        this.roleGroup = roleGroup;
        this.existRoleGroup = existRoleGroup;
    }
    
    @Override
    public void useCondition(SimulationRun sr) {
        int playerNum = player.getPosition() - 1;
        Set<Role> roles = roleGroup.getRoles();
        Set<Role> existRoles = existRoleGroup.getRoles();
        BoolVar[] vars = new BoolVar[roles.size() + sr.playerRole.length * roles.size()];
        int i = 0;
        for (Role r : roles) {
           int roleNum = r.ordinal();
           vars[i] = sr.playerRole[playerNum][roleNum];
           i++; 
        }
        for (int p = 0; p < sr.playerRole.length; p++) {
            for (Role r : existRoles) {
               int roleNum = r.ordinal();
               vars[i] = sr.playerRole[p][roleNum];
               i++; 
            }
        }
        sr.model.sum(vars, ">=", 1).post();
    }

}
