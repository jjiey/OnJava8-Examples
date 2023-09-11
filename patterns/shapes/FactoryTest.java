// patterns/shapes/FactoryTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package patterns.shapes;

import java.util.stream.Stream;

public class FactoryTest {

    private static final Stream<String> STREAM = Stream.of("Circle", "Square", "Triangle", "Square", "Circle", "Circle", "Triangle");

    public static void test(patterns.shapes.FactoryMethod factory) {
        STREAM.map(factory::create)
                .peek(patterns.shapes.Shape::draw)
                .peek(patterns.shapes.Shape::erase)
                .count(); // Terminal operation
    }
}
