package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import townofsalemcalculator.Conditions.Abstract.InheritConditions.PlayerIsRoleGroupCondition;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;

/**
 * The condition that a Player must have a certain role (is known at the start about yourself)
 * @author Multifacio
 * @version 1.1
 * @since 2017-12-30
 */
public class RoleKnownOfPlayer extends PlayerIsRoleGroupCondition {
    public RoleKnownOfPlayer(Player player, Role role) {
        super(player, new SingleRoleGroup(role));
    }
}
