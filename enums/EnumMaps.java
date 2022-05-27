// enums/EnumMaps.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Basics of EnumMaps
// {java enums.EnumMaps}
package enums;

import java.util.EnumMap;
import java.util.Map;

import static enums.AlarmPoints.BATHROOM;
import static enums.AlarmPoints.KITCHEN;
import static enums.AlarmPoints.UTILITY;

interface Command {
    void action();
}

/**
 * 使用 EnumMap
 * 命令模式
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<enums.AlarmPoints, Command> em = new EnumMap<>(enums.AlarmPoints.class);
        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));
        for (Map.Entry<enums.AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
        try {
            // If there's no value for a particular key:
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}
/* Output:
BATHROOM: Bathroom alert!
KITCHEN: Kitchen fire!
Expected: java.lang.NullPointerException
*/
