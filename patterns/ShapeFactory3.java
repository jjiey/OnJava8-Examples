// patterns/ShapeFactory3.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Polymorphic factory methods.

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

interface PolymorphicFactory {

    patterns.shapes.Shape create();
}

class RandomShapes implements Supplier<patterns.shapes.Shape> {

    private final PolymorphicFactory[] factories;
    private final Random rand = new Random(42);

    RandomShapes(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    @Override
    public patterns.shapes.Shape get() {
        return factories[rand.nextInt(factories.length)].create();
    }
}

/**
 * 多态工厂
 */
public class ShapeFactory3 {

    public static void main(String[] args) {
        // [1]
        RandomShapes rs = new RandomShapes(
                patterns.shapes.Circle::new, patterns.shapes.Square::new, patterns.shapes.Triangle::new
        );
        Stream.generate(rs)
                .limit(6)
                .peek(patterns.shapes.Shape::draw)
                .peek(patterns.shapes.Shape::erase)
                .count();
    }
}
/* Output:
Triangle[0] draw
Triangle[0] erase
Circle[1] draw
Circle[1] erase
Circle[2] draw
Circle[2] erase
Triangle[3] draw
Triangle[3] erase
Circle[4] draw
Circle[4] erase
Square[5] draw
Square[5] erase
*/
