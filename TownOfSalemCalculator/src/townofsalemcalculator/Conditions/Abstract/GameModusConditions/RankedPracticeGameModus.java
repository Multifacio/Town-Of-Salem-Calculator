package townofsalemcalculator.Conditions.Abstract.GameModusConditions;

import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownSupportNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownInvestigativeNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownKillingNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownProtectiveNonCoven;
import java.util.List;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralEvilNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralKillingNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
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
