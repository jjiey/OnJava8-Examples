// enums/RandomTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

enum Activity {
    SITTING,
    LYING,
    STANDING,
    HOPPING,
    RUNNING,
    DODGING,
    JUMPING,
    FALLING,
    FLYING
}

/**
 * 随机选择测试
 */
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(onjava.Enums.random(Activity.class) + " ");
        }
    }
}
/* Output:
STANDING FLYING RUNNING STANDING RUNNING STANDING LYING
DODGING SITTING RUNNING HOPPING HOPPING HOPPING RUNNING
STANDING LYING FALLING RUNNING FLYING LYING
*/
