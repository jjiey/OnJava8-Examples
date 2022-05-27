// enums/Burrito2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java enums.Burrito2}
package enums;

import static enums.SpicinessEnum.HOT;
import static enums.SpicinessEnum.MEDIUM;
import static enums.SpicinessEnum.NOT;

/**
 * 将静态类型导入用于 enum
 */
public class Burrito2 {

    enums.SpicinessEnum degree;

    public Burrito2(enums.SpicinessEnum degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito2(NOT));
        System.out.println(new Burrito2(MEDIUM));
        System.out.println(new Burrito2(HOT));
    }
}
/* Output:
Burrito is NOT
Burrito is MEDIUM
Burrito is HOT
*/
