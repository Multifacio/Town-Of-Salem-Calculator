package townofsalemcalculator.Game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import townofsalemcalculator.Conditions.Concrete.AmnesiacRemembered;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.Condition;

/**
 * Amnesiac Determine will determine which roles the Amnesiac has remembered
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-25
 */
public class AmnesiacDetermine {
    public static Set<Role> getRememberedRoles(List<Condition> previousConditions) {
        Set<Role> amnesiacTurnedInto = new HashSet();
        for(Condition cc : previousConditions) {
            //For each concrete condition check whether it is an Amnesiac Remembered condition
            if (cc instanceof AmnesiacRemembered) {
                //For every Amnesiac concrete condition add the role
                AmnesiacRemembered cc2 = (AmnesiacRemembered) cc;
                amnesiacTurnedInto.add(cc2.getRole());
            }
        }
        return amnesiacTurnedInto;
    }
}
