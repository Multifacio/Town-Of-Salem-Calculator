package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The condition that a Player must have a certain role
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class RoleKnownOfPlayer extends EitherRoleForRoleSelecter {
    
    /**
     * Create a Role Known Of Player condition
     * @param player The player of which the role is known
     * @param role The role of that player
     */
    public RoleKnownOfPlayer(Player player, Role role) {
        super(player, new SingleRoleGroup(role));
    }
}
