// enums/UpcastEnum.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// No values() method if you upcast an enum

enum Search {
    HITHER,
    YON
}

/**
 * 将 enum 实例向上转型为 Enum 后，values() 方法不可访问
 * 可以通过 getEnumConstants() 方法取得所有 enum 实例
 */
public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        // Upcast
        Enum<Search> e = Search.HITHER;
        // e.values(); // No values() in Enum
        for (Enum<Search> en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
/* Output:
HITHER
YON
*/
