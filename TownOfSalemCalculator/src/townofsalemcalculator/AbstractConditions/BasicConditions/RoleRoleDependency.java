package townofsalemcalculator.AbstractConditions.BasicConditions;

import java.util.List;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleSelecter;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_ConditionImplementation;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_Condition_RoleRoleDependency;
import townofsalemcalculator.AbstractConditions.AbstractCondition;

/**
 * The condition that a role can only exist if another role exists. For example the Vampire Hunter can only exists if there is a Vampire.
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class RoleRoleDependency implements AbstractCondition {
    private final List<? extends RoleSelecter> startCategories; //The list of all Start Categories in a game
    private final Role dependentRole; //The role that cannot exist if the influenceRole does not exist
    private final Role influenceRole; //The role that must exist in order for the dependentRole to exist
    
    /**
     * Create a Role Role Dependency condition
     * @param startCategories The list of all Start Categories in a game
     * @param dependentRole The role that cannot exist if the influenceRole does not exist
     * @param influenceRole The role that must exist in order for the dependentRole to exist
     */
    public RoleRoleDependency(List<? extends RoleSelecter> startCategories, Role dependentRole, Role influenceRole) {
        this.startCategories = startCategories;
        this.dependentRole = dependentRole;
        this.influenceRole = influenceRole;
    }

    @Override
    public PCLO_ConditionImplementation getPCLO_Implementation() {
        return new PCLO_Condition_RoleRoleDependency(startCategories, dependentRole, influenceRole);
    }
}
