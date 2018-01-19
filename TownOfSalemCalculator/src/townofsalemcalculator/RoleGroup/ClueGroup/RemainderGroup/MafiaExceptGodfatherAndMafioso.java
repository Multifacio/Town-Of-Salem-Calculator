package townofsalemcalculator.RoleGroup.ClueGroup.RemainderGroup;

import townofsalemcalculator.RoleGroup.ClueGroup.RemainderGroup.GodfatherAndMafioso;
import townofsalemcalculator.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.RoleGroup.RoleGroup;

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
