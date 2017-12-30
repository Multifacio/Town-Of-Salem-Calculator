package townofsalemcalculator.RoleGroup;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The All Roles Non Coven Group test
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class AllRolesNonCovenTest {
    private static final int TOTAL_AMOUNT_OF_NON_COVEN_ROLES = 33; //The total expected amount of non coven roles
    
    /**
     * Check the amount of roles in the AllRolesNonCoven class and compare this to the expected amount of non coven roles.
     */
    @Test
    public void checkAmountOfRoles() {
        RoleGroup rg = new AllRolesNonCoven();
        assertTrue("Expected amount of roles does not match", rg.getRoles().size() == TOTAL_AMOUNT_OF_NON_COVEN_ROLES);
    }
    
}
