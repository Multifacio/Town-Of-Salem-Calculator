package townofsalemcalculator.RoleGroup.ClueGroup.RoleAddGroup;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import townofsalemcalculator.Role;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;

/**
 * The Standard Include Group test
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-18
 */
public class StandardIncludeTest {
    /**
     * Amnesiac has turned into an Executioner. This Amnesiac can become a Jester since an Executioner can turn into a Jester
     */
    @Test
    public void testIfAmnesiacCanBecomeJester() {
        Set<Role> expectedResult = new HashSet();
        expectedResult.add(Amnesiac);
        expectedResult.add(Executioner);
        expectedResult.add(Jester);
        
        Set<Role> amnesiacTurnedInto = new HashSet();
        amnesiacTurnedInto.add(Executioner);
        RoleGroup rg = new StandardInclude(new SingleRoleGroup(Jester), amnesiacTurnedInto);
        Set<Role> result = rg.getRoles();
        
        assertTrue("Amnesiac turned into executioner into jester test case failed", result.equals(expectedResult));
    }
    
    /**
     * Check if only Mafioso can become Godfather. A Janitor for example may not become Godfather
     */
    @Test
    public void testChangeIntoGodfather() {
        Set<Role> expectedResult = new HashSet();
        expectedResult.add(Godfather);
        expectedResult.add(Mafioso);
        
        RoleGroup rg = new StandardInclude(new SingleRoleGroup(Godfather), new HashSet());
        Set<Role> result = rg.getRoles();
        
        assertTrue("Change Into Godfather test case failed", result.equals(expectedResult));
    }
    
}
