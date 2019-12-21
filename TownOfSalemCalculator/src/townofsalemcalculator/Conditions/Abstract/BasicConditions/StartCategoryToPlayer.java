package townofsalemcalculator.Conditions.Abstract.BasicConditions;

import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * The condition that all start category roles are mapped to player roles
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-01
 */
public class StartCategoryToPlayer implements Condition {
    
    @Override
    public void useCondition(SimulationRun sr) {
        Role[] allRoles = Role.values();
        for (int i = 0; i < allRoles.length; i++) {
            int totalLength = sr.startCategoryRole.length + sr.playerRole.length;
            BoolVar[] vars = new BoolVar[totalLength];
            int[] scalars = new int[totalLength];
            int count = 0;
            for (int j = 0; j < sr.startCategoryRole.length; j++) {
                vars[count] = sr.startCategoryRole[j][i];
                scalars[count] = 1;
                count++;
            }
            for (int j = 0; j < sr.playerRole.length; j++) {
                vars[count] = sr.playerRole[j][i];
                scalars[count] = -1;
                count++;
            }
            sr.model.scalar(vars, scalars, "=", 0).post();
        }
    }

}
