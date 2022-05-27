// enums/EnumSets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Operations on EnumSets
// {java enums.EnumSets}
package enums;

import java.util.EnumSet;

import static enums.AlarmPoints.BATHROOM;
import static enums.AlarmPoints.KITCHEN;
import static enums.AlarmPoints.OFFICE1;
import static enums.AlarmPoints.OFFICE4;
import static enums.AlarmPoints.STAIR1;
import static enums.AlarmPoints.STAIR2;

public class EnumSets {

    public static void main(String[] args) {
        // Empty
        EnumSet<enums.AlarmPoints> points = EnumSet.noneOf(enums.AlarmPoints.class);
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(enums.AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        // points 的补集
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
/* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM,
UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4,
KITCHEN]
*/
