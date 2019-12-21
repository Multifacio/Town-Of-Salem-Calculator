package townofsalemcalculator.Conditions.Abstract.BasicConditions;

import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * The condition that a Vampire Hunter only exists if there is a Vampire
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-01
 */
public class VampireHunterCondition implements Condition {

    @Override
    public void useCondition(SimulationRun sr) {
        int vampireNum = Role.Vampire.ordinal();
        int vampireHunterNum = Role.VampireHunter.ordinal();
        for (int i = 0; i < sr.startCategoryRole.length; i++) {
            int totalLength = sr.startCategoryRole.length + 1;
            BoolVar[] vars = new BoolVar[totalLength];
            int[] scalars = new int[totalLength];
            for (int j = 0; j < sr.startCategoryRole.length; j++) {
                vars[j] = sr.startCategoryRole[j][vampireNum];
                scalars[j] = 1;
            }
            vars[sr.startCategoryRole.length] = sr.startCategoryRole[i][vampireHunterNum];
            scalars[sr.startCategoryRole.length] = -1;
            sr.model.scalar(vars, scalars, ">=", 0);
        }
    }

}
