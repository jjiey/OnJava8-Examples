// enums/RoShamBo1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstration of multiple dispatching
// {java enums.RoShamBo1}
package enums;

import java.util.Random;

/**
 * “石头、剪刀、布”
 * 使用接口多路分发
 *
 * @see enums.RoShamBo2
 * @see enums.RoShamBo3
 * @see enums.RoShamBo4
 * @see enums.RoShamBo5
 * @see enums.RoShamBo6
 */
public class RoShamBo1 {

    private static final Random rand = new Random(47);

    public static enums.Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new enums.Scissors();
            case 1:
                return new enums.Paper();
            case 2:
                return new enums.Rock();
        }
    }

    public static void match(enums.Item a, enums.Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            enums.Item a = newItem();
            enums.Item b = newItem();
            match(a, b);
        }
    }
}
/* Output:
Rock vs. Rock: DRAW
Paper vs. Rock: WIN
Paper vs. Rock: WIN
Paper vs. Rock: WIN
Scissors vs. Paper: WIN
Scissors vs. Scissors: DRAW
Scissors vs. Paper: WIN
Rock vs. Paper: LOSE
Paper vs. Paper: DRAW
Rock vs. Paper: LOSE
Paper vs. Scissors: LOSE
Paper vs. Scissors: LOSE
Rock vs. Scissors: WIN
Rock vs. Paper: LOSE
Paper vs. Rock: WIN
Scissors vs. Paper: WIN
Paper vs. Scissors: LOSE
Paper vs. Scissors: LOSE
Paper vs. Scissors: LOSE
Paper vs. Scissors: LOSE
*/
