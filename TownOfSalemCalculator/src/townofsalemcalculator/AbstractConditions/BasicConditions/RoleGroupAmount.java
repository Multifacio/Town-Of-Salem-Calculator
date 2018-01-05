package townofsalemcalculator.AbstractConditions.BasicConditions;

import java.util.List;
import townofsalemcalculator.Comparison;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.Game.RoleSelecter;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_ConditionImplementation;
import townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation.PCLO_Condition_RoleGroupAmount;
import townofsalemcalculator.AbstractConditions.AbstractCondition;

/**
 * A Role Group Amount is a condition that in a list of Role Selecters a certain Role Group must occur a given (minimum/maximum) amount of times.
 * For example in these 5 players there must be at least 2 Town Support roles. 
 * @author Multifacio
 * @version 1.0
 * @since 2017-12-30
 */
public class RoleGroupAmount implements AbstractCondition {
    private final List<? extends RoleSelecter> roleSelecters; //The list of Role Selecters in which roleGroup must appear (at least/at most) amount of times
    private final RoleGroup roleGroup; //The role group that must appear in the roleSelecters (at least/at most) amount of times
    private final Comparison comparison; //Determines whether the roleGroup must appear at least, at most or an equal amount of times as amount in the roleSelecters
    private final int amount; //The amount of times roleGroup must appear (at least/at most) in the roleSelecters
    
    /**
     * Create a Role Group Amount condition
     * @param roleSelecters The list of Role Selecters in which roleGroup must appear (at least/at most) amount of times
     * @param roleGroup The role group that must appear in the roleSelecters (at least/at most) amount of times
     * @param comparison Determines whether the roleGroup must appear at least, at most or an equal amount of times as amount in the roleSelecters
     * @param amount The amount of times roleGroup must appear (at least/at most) in the roleSelecters
     */
    public RoleGroupAmount(List<? extends RoleSelecter> roleSelecters, RoleGroup roleGroup, Comparison comparison, int amount) {
        this.roleSelecters = roleSelecters;
        this.roleGroup = roleGroup;
        this.comparison = comparison;
        this.amount = amount;
    }

    @Override
    public PCLO_ConditionImplementation getPCLO_Implementation() {
        return new PCLO_Condition_RoleGroupAmount(roleSelecters, roleGroup, comparison, amount);
    }
}
