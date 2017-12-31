package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import java.util.List;
import scpsolver.problems.LPWizard;
import scpsolver.problems.LPWizardConstraint;
import townofsalemcalculator.Counter;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleSelecter;

public class PCLO_RoleRoleDependency implements PCLO_ConditionImplementation {
    private final List<RoleSelecter> startCategories; //The list of all Start Categories in a game
    private final Role dependentRole; //The role that cannot exist if the influenceRole does not exist
    private final Role influenceRole; //The role that must exist in order for the dependentRole to exist
    
    /**
     * @param startCategories The list of all Start Categories in a game
     * @param dependentRole The role that cannot exist if the influenceRole does not exist
     * @param influenceRole The role that must exist in order for the dependentRole to exist
     */
    public PCLO_RoleRoleDependency(List<RoleSelecter> startCategories, Role dependentRole, Role influenceRole) {
        this.startCategories = startCategories;
        this.dependentRole = dependentRole;
        this.influenceRole = influenceRole;
    }

    @Override
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        for(RoleSelecter rs : startCategories) {
            LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), -1.0, "<=");
            counter.increment();
            for(RoleSelecter rs2 : startCategories) {
                con.plus("RS" + rs2.getId() + "R" + influenceRole.toString(), 1.0);
            }
            con.plus("RS" + rs.getId() + "R" + dependentRole.toString(), -1.0);
            con.plus("Condition" + conditionNumber, -1.0);
        }
    }

    @Override
    public void setCheckCondition(LPWizard lpw, Counter counter) {
        for(RoleSelecter rs : startCategories) {
            LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), 0.0, "<=");
            counter.increment();
            for(RoleSelecter rs2 : startCategories) {
                con.plus("RS" + rs2.getId() + "R" + influenceRole.toString(), 1.0);
            }
            con.plus("RS" + rs.getId() + "R" + dependentRole.toString(), -1.0);
        }
    }
}
