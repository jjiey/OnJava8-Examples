// onjava/Enums.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package onjava;

import java.util.*;

/**
 * 随机选择
 */
public class Enums {

    private static final Random RAND = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[RAND.nextInt(values.length)];
    }
}
