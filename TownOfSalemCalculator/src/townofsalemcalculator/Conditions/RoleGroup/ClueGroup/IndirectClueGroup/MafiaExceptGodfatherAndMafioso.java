package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup;

import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;

/**
 * The group consisting of all Mafia roles except the Mafioso and the Godfather
 * @author Multifacio
 * @version 1.0
 * @since 2017-1-7
 */
public class MafiaExceptGodfatherAndMafioso extends DifferenceRoleGroup {   
    public MafiaExceptGodfatherAndMafioso() {
        super(new MafiaGroupNonCoven(), new GodfatherAndMafioso());
    }
}
