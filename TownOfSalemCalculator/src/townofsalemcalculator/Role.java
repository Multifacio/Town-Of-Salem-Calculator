package townofsalemcalculator;

import java.util.Arrays;
import java.util.List;

/**
 * All the different roles within Town Of Salem (which includes Town, Mafia and Neutral roles)
 * @author Multifacio
 * @version 1.1
 * @since 2017-12-29
 */
public enum Role {
    //All Town roles
    Bodyguard(new String[]{"BG", "Bodyguard"}),
    Doctor(new String[]{"Dr", "Doctor"}),
    Escort(new String[]{"Escort"}),
    Investigator(new String[]{"Investigator"}),
    Jailor(new String[]{"Jailor"}),
    Lookout(new String[]{"Lookout"}),
    Mayor(new String[]{"Mayor"}),
    Medium(new String[]{"Medium"}),
    Retributionist(new String[]{"Retributionist"}),
    Sheriff(new String[]{"Sheriff"}),
    Spy(new String[]{"Spy"}),
    Transporter(new String[]{"Transporter"}),
    VampireHunter(new String[]{"Vampire", "Hunter", "VH"}),
    Veteran(new String[]{"Veteran"}),
    Vigilante(new String[]{"Vigilante"}),
    
    //All Mafia roles
    Blackmailer(new String[]{"Blackmailer", "BMer"}),
    Consigliere(new String[]{"Consigliere"}),
    Consort(new String[]{"Consort"}),
    Disguiser(new String[]{"Disguiser"}),
    Forger(new String[]{"Forger"}),
    Framer(new String[]{"Framer"}),
    Godfather(new String[]{"Godfather", "GF"}),
    Janitor(new String[]{"Janitor"}),
    Mafioso(new String[]{"Mafioso"}),
    
    //All Neutral roles
    Amnesiac(new String[]{"Amnesiac"}),
    Arsonist(new String[]{"Arsonist"}),
    Executioner(new String[]{"Executioner"}),
    Jester(new String[]{"Jester"}),
    SerialKiller(new String[]{"Serial", "Killer", "SK"}),
    Survivor(new String[]{"Survivor"}),
    Vampire(new String[]{"Vampire"}),
    Werewolf(new String[]{"Werewolf", "WW"}),
    Witch(new String[]{"Witch"});
    
    private final String[] keyWords;
    
    private Role(String[] keyWords) {
        this.keyWords = keyWords;
    }
    
    public List<String> getKeyWords() {
        return Arrays.asList(keyWords);
    }
}
