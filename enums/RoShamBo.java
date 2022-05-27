// enums/RoShamBo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Common tools for RoShamBo examples
package enums;

import onjava.Enums;

public class RoShamBo {

    public static <T extends Enum<T> & enums.Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            T a = Enums.random(rsbClass);
            T b = Enums.random(rsbClass);
            match(a, b);
        }
    }

    public static <T extends enums.Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }
}
