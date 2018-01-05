package townofsalemcalculator.AbstractConditions.GameModusConditions;

import java.util.List;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.RoleGroup.NeutralGroup.NeutralEvilNonCoven;
import townofsalemcalculator.RoleGroup.NeutralGroup.NeutralKillingNonCoven;
import townofsalemcalculator.RoleGroup.RoleGroup;
import townofsalemcalculator.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.RoleGroup.TownGroup.*;
import townofsalemcalculator.Game.StartCategory;

/**
 * The Ranked Practice Game Modus 
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-1
 */
public class RankedPracticeGameModus extends GameModusAbstractCondition {

    public RankedPracticeGameModus(List<StartCategory> startCategories) {
        super(startCategories);
    }

    @Override
    protected RoleGroup[] getLinkedRoleGroups() {
        return new RoleGroup[]{new SingleRoleGroup(Jailor), new TownInvestigativeNonCoven(), new TownInvestigativeNonCoven(), new TownSupportNonCoven(), 
            new TownProtectiveNonCoven(), new TownKillingNonCoven(), new TownGroupNonCoven(), new TownGroupNonCoven(),
            new TownGroupNonCoven(), new SingleRoleGroup(Godfather), new SingleRoleGroup(Mafioso), new MafiaGroupNonCoven(),
            new MafiaGroupNonCoven(), new NeutralKillingNonCoven(), new NeutralEvilNonCoven()};
    }
    
}
