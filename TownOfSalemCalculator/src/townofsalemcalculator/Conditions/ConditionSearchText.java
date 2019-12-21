package townofsalemcalculator.Conditions;

import townofsalemcalculator.Player;

/**
 * A Condition Search Text is the text that will be appended to multiple conditions
 * @author Multifacio
 * @version 1.0
 * @since 2018-11-03
 */
public class ConditionSearchText {
    public static String getPlayerIndication(Player player) {
        return player.getUsername() + " (" + player.getPosition() + ")";
    }
    
    public static String getSeperation() {
        return ": ";
    }
}
