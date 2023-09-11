// patterns/ShapeFactory1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A basic static factory method.

/**
 * 工厂模式
 */
public class ShapeFactory1 implements patterns.shapes.FactoryMethod {

    @Override
    public patterns.shapes.Shape create(String type) {
        switch (type) {
            case "Circle":
                return new patterns.shapes.Circle();
            case "Square":
                return new patterns.shapes.Square();
            case "Triangle":
                return new patterns.shapes.Triangle();
            default:
                throw new patterns.shapes.BadShapeCreation(type);
        }
    }

    public static void main(String[] args) {
        patterns.shapes.FactoryTest.test(new ShapeFactory1());
    }
}
/* Output:
Circle[0] draw
Circle[0] erase
Square[1] draw
Square[1] erase
Triangle[2] draw
Triangle[2] erase
Square[3] draw
Square[3] erase
Circle[4] draw
Circle[4] erase
Circle[5] draw
Circle[5] erase
Triangle[6] draw
Triangle[6] erase
*/
