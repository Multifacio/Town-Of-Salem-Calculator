package townofsalemcalculator.Simulations.PCLO_Simulation.PCLO_ConditionImplementation;

import java.util.List;
import scpsolver.problems.LPWizard;
import scpsolver.problems.LPWizardConstraint;
import townofsalemcalculator.Counter;
import townofsalemcalculator.Player;
import townofsalemcalculator.Role;
import townofsalemcalculator.RoleGroup.AllRoles;
import townofsalemcalculator.RoleSelecter;
import townofsalemcalculator.StartCategory;

public class PCLO_Condition_StartCategoriesToPlayers implements PCLO_ConditionImplementation {
    private final List<Player> players; //The list of all Players participating in a game
    private final List<StartCategory> startCategories; //The list of all Start Categories in a game
    
    /**
     * @param players The list of all Players participating in a game
     * @param startCategories The list of all Start Categories in a game
     */
    public PCLO_Condition_StartCategoriesToPlayers(List<Player> players, List<StartCategory> startCategories) {
        this.players = players;
        this.startCategories = startCategories;
    }

    @Override
    public void addHoldCondition(LPWizard lpw, Counter counter, int conditionNumber) {
        //For each role the amount of that role in the Start Categories must be equal to the amount of that role in the Players
        for (Role r : new AllRoles().getRoles()) {
            LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), (double) players.size(), ">=");
            counter.increment();
            for (Player p : players) {
                    con.plus("RS" + p.getId() + "R" + r.toString(), 1.0);
            }
            for (StartCategory sc : startCategories) {
                    con.plus("RS" + sc.getId() + "R" + r.toString(), -1.0);
            }
            con.plus("Condition" + conditionNumber, (double) (players.size()));
            
            con = lpw.addConstraint("Constraint" + counter.getCounterValue(), (double) (startCategories.size() * -1), "<=");
            counter.increment();
            for (Player p : players) {
                    con.plus("RS" + p.getId() + "R" + r.toString(), 1.0);
            }
            for (StartCategory sc : startCategories) {
                    con.plus("RS" + sc.getId() + "R" + r.toString(), -1.0);
            }
            con.plus("Condition" + conditionNumber, (double) (startCategories.size() * -1));
        }
    }

    @Override
    public void setCheckCondition(LPWizard lpw, Counter counter) {
        //For each role the amount of that role in the Start Categories must be equal to the amount of that role in the Players
        for (Role r : new AllRoles().getRoles()) {
            LPWizardConstraint con = lpw.addConstraint("Constraint" + counter.getCounterValue(), 0.0, "=");
            counter.increment();
            for (Player p : players) {
                    con.plus("RS" + p.getId() + "R" + r.toString(), 1.0);
            }
            for (StartCategory sc : startCategories) {
                    con.plus("RS" + sc.getId() + "R" + r.toString(), -1.0);
            }
        }
    }
}
