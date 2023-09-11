// patterns/SingletonPattern2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 单例模式
 */
public class SingletonPattern2 {

    public static void main(String[] args) {
        Single<Double> pi = new Single<>(Double.valueOf(3.14159));
        Double x = pi.get();
        System.out.println(x);
//        pi = new Single<>(Double.valueOf(3.14159));
    }
}
/* Output:
3.14159
*/
