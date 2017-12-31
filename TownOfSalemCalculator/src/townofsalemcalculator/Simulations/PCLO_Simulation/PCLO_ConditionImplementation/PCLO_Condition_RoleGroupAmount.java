package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import java.util.List;
import scpsolver.problems.LPWizard;
import townofsalemcalculator.Comparison;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleSelecter;

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
    public void addHoldCondition(LPWizard lpw, int conditionNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCheckCondition(LPWizard lpw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
