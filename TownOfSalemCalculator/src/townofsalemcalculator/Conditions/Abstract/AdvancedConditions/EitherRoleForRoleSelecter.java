package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import java.util.Collections;
import static townofsalemcalculator.Comparison.Equal;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.RoleGroupAmount;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Game.RoleSelecter;

/**
 * The Condition that a Role Selecter must be either one of these roles. For example John Proctor is either Escort, Transport or Consort.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class EitherRoleForRoleSelecter extends RoleGroupAmount {
    
    /**
     * Create an Either Role For Role Selector condition
     * @param roleSelecter The Role Selecter for which it is known to which roleGroup it belongs
     * @param roleGroup The Role Group to which the roleSelecter belongs
     */
    public EitherRoleForRoleSelecter(RoleSelecter roleSelecter, RoleGroup roleGroup) {
        super(Collections.singletonList(roleSelecter), roleGroup, Equal, 1);
    }
    
}
