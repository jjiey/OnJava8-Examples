// enums/NonEnum.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * getEnumConstants() 是 Class 上的方法，所以甚至可以对不是枚举的类调用此方法，此时该方法返回 null
 */
public class NonEnum {

    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}
/* Output:
Expected: java.lang.NullPointerException
*/
