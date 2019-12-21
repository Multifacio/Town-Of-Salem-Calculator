package townofsalemcalculator.Conditions.Concrete;

import java.util.List;
import townofsalemcalculator.Conditions.Condition;
import static townofsalemcalculator.Conditions.ConditionSearchText.getPlayerIndication;
import static townofsalemcalculator.Conditions.ConditionSearchText.getSeperation;
import townofsalemcalculator.Conditions.RoleGroup.CompositeRoleGroup;
import townofsalemcalculator.Conditions.RoleGroup.SingleRoleGroup;
import townofsalemcalculator.Player;
import townofsalemcalculator.Simulation.SimulationRun;
import townofsalemcalculator.Conditions.SearchableCondition;
import static townofsalemcalculator.Role.Arsonist;
import static townofsalemcalculator.Role.Blackmailer;
import static townofsalemcalculator.Role.Bodyguard;
import static townofsalemcalculator.Role.Consigliere;
import static townofsalemcalculator.Role.Consort;
import static townofsalemcalculator.Role.Disguiser;
import static townofsalemcalculator.Role.Doctor;
import static townofsalemcalculator.Role.Escort;
import static townofsalemcalculator.Role.Forger;
import static townofsalemcalculator.Role.Framer;
import static townofsalemcalculator.Role.Godfather;
import static townofsalemcalculator.Role.Investigator;
import static townofsalemcalculator.Role.Janitor;
import static townofsalemcalculator.Role.Lookout;
import static townofsalemcalculator.Role.Mafioso;
import static townofsalemcalculator.Role.SerialKiller;
import static townofsalemcalculator.Role.Sheriff;
import static townofsalemcalculator.Role.Spy;
import static townofsalemcalculator.Role.Transporter;
import static townofsalemcalculator.Role.Vampire;
import static townofsalemcalculator.Role.VampireHunter;
import static townofsalemcalculator.Role.Vigilante;
import static townofsalemcalculator.Role.Werewolf;
import static townofsalemcalculator.Role.Witch;

/**
 * The Concrete Condition that the Lookout sees somebody visiting someone
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-02
 */
public class LookoutClueVisit implements Condition, SearchableCondition {
    private final Player player;
    
    public LookoutClueVisit(Player player) {
        this.player = player;
    }
    
    @Override
    public String getCondition() {
        return getPlayerIndication(player) + getSeperation() + "visited your target last night!";
    }

    @Override
    public List<String> keyWords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void useCondition(SimulationRun sr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    static class LookoutClueGroup extends CompositeRoleGroup {    
        public LookoutClueGroup() {
            addRoleGroup(new SingleRoleGroup(Investigator));
            addRoleGroup(new SingleRoleGroup(Lookout));
            addRoleGroup(new SingleRoleGroup(Sheriff));
            addRoleGroup(new SingleRoleGroup(Spy));
            addRoleGroup(new SingleRoleGroup(VampireHunter));
            addRoleGroup(new SingleRoleGroup(Vigilante));
            addRoleGroup(new SingleRoleGroup(Bodyguard));
            addRoleGroup(new SingleRoleGroup(Doctor));
            addRoleGroup(new SingleRoleGroup(Escort));
            addRoleGroup(new SingleRoleGroup(Transporter));
            addRoleGroup(new SingleRoleGroup(Disguiser));
            addRoleGroup(new SingleRoleGroup(Forger));
            addRoleGroup(new SingleRoleGroup(Framer));
            addRoleGroup(new SingleRoleGroup(Janitor));
            addRoleGroup(new SingleRoleGroup(Godfather));
            addRoleGroup(new SingleRoleGroup(Mafioso));
            addRoleGroup(new SingleRoleGroup(Blackmailer));
            addRoleGroup(new SingleRoleGroup(Consigliere));
            addRoleGroup(new SingleRoleGroup(Consort));
            addRoleGroup(new SingleRoleGroup(Witch));
            addRoleGroup(new SingleRoleGroup(Vampire));
            addRoleGroup(new SingleRoleGroup(Arsonist));
            addRoleGroup(new SingleRoleGroup(SerialKiller));
            addRoleGroup(new SingleRoleGroup(Werewolf));
        }
    }
}
