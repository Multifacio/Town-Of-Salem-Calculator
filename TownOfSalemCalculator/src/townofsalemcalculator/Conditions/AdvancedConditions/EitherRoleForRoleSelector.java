package townofsalemcalculator.Conditions.AdvancedConditions;

import java.util.Collections;
import static townofsalemcalculator.Comparison.Equal;
import townofsalemcalculator.Conditions.BasicConditions.RoleGroupAmount;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleSelecter;

/**
 * The Condition that a Role Selecter must be either one of these roles. For example John Proctor is either Escort, Transport or Consort.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class EitherRoleForRoleSelector extends RoleGroupAmount {
    
    /**
     * Create an Either Role For Role Selector condition
     * @param roleSelecter The Role Selecter for which it is known to which roleGroup it belongs
     * @param roleGroup The Role Group to which the roleSelecter belongs
     */
    public EitherRoleForRoleSelector(RoleSelecter roleSelecter, RoleGroup roleGroup) {
        super(Collections.singletonList(roleSelecter), roleGroup, Equal, 1);
    }
    
}
