package townofsalemcalculator.Conditions.Abstract.AdvancedConditions;

import java.util.HashSet;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.BoolVar;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.PlayerCondition;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.StartCategoryToPlayer;
import townofsalemcalculator.Conditions.Abstract.BasicConditions.VampireHunterCondition;
import townofsalemcalculator.Conditions.Abstract.InheritConditions.CompositeCondition;
import townofsalemcalculator.Conditions.Condition;
import townofsalemcalculator.GameModus;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.Simulation.SimulationRun;

/**
 * All conditions that hold in every Town of Salem game are included here
 * @author Multifacio
 * @version 1.1
 * @since 2018-1-1
 */
public final class GameCondition extends CompositeCondition {
    public GameCondition(GameModus gameModus, Player yourself, Role yourRole, int playerAmount) {
        addCondition(new InitializeCondition(playerAmount));
        addCondition(new PlayerCondition());
        addCondition(new StartCategoryToPlayer());
        addCondition(new GameModusCondition(gameModus));
        addCondition(new RoleKnownOfPlayer(yourself, yourRole));
        addCondition(new AllUniqueness());
        addCondition(new VampireHunterCondition());
    }
    
    class InitializeCondition implements Condition {
        private final int playerAmount;
        
        public InitializeCondition(int playerAmount) {
            this.playerAmount = playerAmount;
        }
        
        @Override
        public void useCondition(SimulationRun sr) {
            sr.model = new Model("Town Of Salem Game");
            int roleAmount = Role.values().length;
            sr.amnesiacDetermine = new HashSet();
            sr.playerRole = new BoolVar[playerAmount][roleAmount];
            sr.startCategoryRole = new BoolVar[playerAmount][roleAmount];
            for (int i = 0; i < playerAmount; i++) {
                for (int j = 0; j < roleAmount; j++) {
                    sr.playerRole[i][j] = sr.model.boolVar();
                }
            }
        }    
    }
}
