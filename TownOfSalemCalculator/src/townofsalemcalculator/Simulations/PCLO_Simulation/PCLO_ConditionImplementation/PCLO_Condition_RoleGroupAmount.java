package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import java.util.List;
import scpsolver.problems.LPWizard;
import scpsolver.problems.LPWizardConstraint;
import townofsalemcalculator.Comparison;
import static townofsalemcalculator.Comparison.*;
import townofsalemcalculator.Counter;
import townofsalemcalculator.Role;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Game.RoleSelecter;

public class PCLO_Condition_RoleGroupAmount implements PCLO_ConditionImplementation {
    private final List<? extends RoleSelecter> roleSelecters; //The list of Role Selecters in which roleGroup must appear (at least/at most) amount of times
    private final RoleGroup roleGroup; //The role group that must appear in the roleSelecters (at least/at most) amount of times
    private final Comparison comparison; //Determines whether the roleGroup must appear at least, at most or an equal amount of times as amount in the roleSelecters
    private final int amount; //The amount of times roleGroup must appear (at least/at most) in the roleSelecters
    
    /**
     * @param roleSelecters The list of Role Selecters in which roleGroup must appear (at least/at most) amount of times
     * @param roleGroup The role group that must appear in the roleSelecters (at least/at most) amount of times
     * @param comparison Determines whether the roleGroup must appear at least, at most or an equal amount of times as amount in the roleSelecters
     * @param amount The amount of times roleGroup must appear (at least/at most) in the roleSelecters
     */
    public PCLO_Condition_RoleGroupAmount(List<? extends RoleSelecter> roleSelecters, RoleGroup roleGroup, Comparison comparison, int amount) {
        this.roleSelecters = roleSelecters;
        this.roleGroup = roleGroup;
        this.comparison = comparison;
        this.amount = amount;
    }

    @Override
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        if (comparison != GreaterOrEqual) {
            //This constraint will be added in case the comparison is greater or equal or in case the comparison is equal
            LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), (double) roleSelecters.size(), ">=");
            counter.increment();
            for (RoleSelecter rs : roleSelecters) {
                for (Role r : roleGroup.getRoles()) {
                    con.plus("RS" + rs.getId() + "R" + r.toString(), 1.0);
                }
            }
            con.plus("Condition" + conditionNumber, (double) (roleSelecters.size() - amount));
        }
        
        if (comparison != LesserOrEqual) {
            //This constraint will be added in case the comparison is smaller or equal or in case the comparison is equal
            LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), 0.0, "<=");
            counter.increment();
            for (RoleSelecter rs : roleSelecters) {
                for (Role r : roleGroup.getRoles()) {
                    con.plus("RS" + rs.getId() + "R" + r.toString(), 1.0);
                }
            }
            con.plus("Condition" + conditionNumber, (double) (amount * -1));
        }
    }

    @Override
    public void setCheckCondition(LPWizard lpw, Counter counter) {
        LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), (double) amount, comparison.getOppositeComparison().getComparisonOperator());
        counter.increment();
        for (RoleSelecter rs : roleSelecters) {
            for (Role r : roleGroup.getRoles()) {
                con.plus("RS" + rs.getId() + "R" + r.toString(), 1.0);
            }
        }
    }

}
