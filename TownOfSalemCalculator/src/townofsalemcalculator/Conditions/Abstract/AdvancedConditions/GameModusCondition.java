package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import java.util.EnumMap;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.StartCategoryCondition;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.Conditions.RoleGroup.AllRolesNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.MafiaGroup.MafiaGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralBenignNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralEvilNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.NeutralGroup.NeutralKillingNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.RoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownGroupNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownInvestigativeNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownKillingNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownProtectiveNonCoven;
import townofsalemcalculator.Conditions.RoleGroup.TownGroup.TownSupportNonCoven;
import townofsalemcalculator.GameModus;
import static townofsalemcalculator.Role.*;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * A Game Modus is a condition that determines what roles the Start Categories can be based on the Game Modus
 * @author Multifacio
 * @version 1.1
 * @since 2018-11-01
 */
public class GameModusCondition implements Condition {
    private final GameModus gameModus;
    
    public GameModusCondition(GameModus gameModus) {
        this.gameModus = gameModus;
    }
    
    @Override
    public void useCondition(SimulationRun sr) {
        EnumMap<GameModus, RoleGroup[]> mapping = getMapping();
        Condition condition = new StartCategoryCondition(mapping.get(gameModus));
        condition.useCondition(sr);
    }

    public EnumMap<GameModus, RoleGroup[]> getMapping() {
        EnumMap<GameModus, RoleGroup[]> mapping = new EnumMap<>(GameModus.class);
        
        //The Classic Game Modus
        mapping.put(GameModus.Classic, new RoleGroup[]{new SingleRoleGroup(Sheriff), new SingleRoleGroup(Doctor), new SingleRoleGroup(Investigator),
        new SingleRoleGroup(Jailor), new SingleRoleGroup(Medium), new SingleRoleGroup(Godfather), new SingleRoleGroup(Framer), new SingleRoleGroup(Executioner),
        new SingleRoleGroup(Escort), new SingleRoleGroup(Mafioso), new SingleRoleGroup(Lookout), new SingleRoleGroup(SerialKiller), new TownKillingNonCoven(),
        new SingleRoleGroup(Jester), new TownGroupNonCoven()});
        
        //The Old Ranked Practice Game Modus
        mapping.put(GameModus.OldRankedPractice, new RoleGroup[]{new SingleRoleGroup(Jailor), new TownInvestigativeNonCoven(), new TownInvestigativeNonCoven(),
        new TownSupportNonCoven(), new TownSupportNonCoven(), new TownProtectiveNonCoven(), new TownKillingNonCoven(), new TownGroupNonCoven(),
        new SingleRoleGroup(Godfather), new SingleRoleGroup(Mafioso), new MafiaGroupNonCoven(), new NeutralKillingNonCoven(), new NeutralEvilNonCoven(),
        new NeutralBenignNonCoven(), new AllRolesNonCoven()});
        
        //The New Ranked Practice Game Modus
        mapping.put(GameModus.RankedPractice, new RoleGroup[]{new SingleRoleGroup(Jailor), new TownInvestigativeNonCoven(), new TownInvestigativeNonCoven(),
        new TownProtectiveNonCoven(), new TownKillingNonCoven(), new TownSupportNonCoven(), new TownGroupNonCoven(), new TownGroupNonCoven(), 
        new TownGroupNonCoven(), new SingleRoleGroup(Godfather), new SingleRoleGroup(Mafioso), new MafiaGroupNonCoven(), new MafiaGroupNonCoven(), 
        new NeutralEvilNonCoven(), new NeutralKillingNonCoven()});
        
        //The New Ranked Game Modus
        mapping.put(GameModus.RankedPractice, new RoleGroup[]{new SingleRoleGroup(Jailor), new TownInvestigativeNonCoven(), new TownInvestigativeNonCoven(),
        new TownProtectiveNonCoven(), new TownKillingNonCoven(), new TownSupportNonCoven(), new TownGroupNonCoven(), new TownGroupNonCoven(), 
        new TownGroupNonCoven(), new SingleRoleGroup(Godfather), new SingleRoleGroup(Mafioso), new MafiaGroupNonCoven(), new MafiaGroupNonCoven(), 
        new NeutralEvilNonCoven(), new NeutralKillingNonCoven()});
        
        return mapping;
    }
}
