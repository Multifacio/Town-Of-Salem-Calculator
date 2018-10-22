package townofsalemcalculator.Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Role;

/**
 * A run instance of a Simulation
 * @author Multifacio
 * @version 1.0
 * @since 2018-10-22
 */
public class SimulationRun {
    public Model model; //This is the model on which constraints are added
    /* The boolean variables for the start categories. The first index is the category index. The second is the role index. 
    For example startCategoryRole[2][6] is the boolean variable whether the 3rd category is a Mayor or not */
    public BoolVar[][] startCategoryRole;
    /* The boolean variables for the player roles. The first index is the player index. The second is the role index. 
    For example startCategoryRole[4][1] is the boolean variable whether the 5th player is a Doctor or not */
    public BoolVar[][] playerRole;
    public Set<Role> amnesiacDetermine; //Contains the roles which an Amnesiac has remembered 
    
    public BoolVar[] get1DimensionalVariableArray() {
        List<BoolVar> variables = new ArrayList();
        for (BoolVar[] arr : startCategoryRole) {
            variables.addAll(Arrays.asList(arr));
        }
        for (BoolVar[] arr : playerRole) {
            variables.addAll(Arrays.asList(arr));
        }
        return variables.toArray(new BoolVar[variables.size()]);
    }
}
