package townofsalemcalculator.AbstractConditions.GameModusConditions;

import java.util.List;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.RoleGroup.TownGroup.TownGroupNonCoven;
import townofsalemcalculator.RoleGroup.TownGroup.TownKillingNonCoven;
import townofsalemcalculator.Game.StartCategory;

/**
 * The Classic Game Modus 
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public class ClassicGameModus extends GameModusAbstractCondition {

    public ClassicGameModus(List<StartCategory> startCategories) {
        super(startCategories);
    }

    @Override
    protected RoleGroup[] getLinkedRoleGroups() {
        return new RoleGroup[]{new SingleRoleGroup(Sheriff), new SingleRoleGroup(Doctor), new SingleRoleGroup(Investigator), new SingleRoleGroup(Jailor), 
            new SingleRoleGroup(Medium), new SingleRoleGroup(Godfather), new SingleRoleGroup(Framer), new SingleRoleGroup(Executioner),
        new SingleRoleGroup(Escort), new SingleRoleGroup(Mafioso), new SingleRoleGroup(Lookout), new SingleRoleGroup(SerialKiller),
        new TownKillingNonCoven(), new SingleRoleGroup(Jester), new TownGroupNonCoven()};
    }
    
}
