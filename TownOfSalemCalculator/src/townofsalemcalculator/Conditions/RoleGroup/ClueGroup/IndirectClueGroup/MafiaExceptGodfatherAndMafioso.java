package townofsalemcalculator.Conditions.RoleGroup.ClueGroup.IndirectClueGroup;

import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.DifferenceRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import static townofsalemcalculator.Role.Godfather;
import static townofsalemcalculator.Role.Mafioso;

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
    
    static class GodfatherAndMafioso extends CompositeRoleGroup {
        public GodfatherAndMafioso() {
            addRoleGroup(new SingleRoleGroup(Godfather));
            addRoleGroup(new SingleRoleGroup(Mafioso));
        }
    }
}


