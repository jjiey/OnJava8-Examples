// enums/menu/Course.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package enums.menu;

/**
 * 枚举的枚举
 */
public enum Course {
    APPETIZER(enums.menu.Food.Appetizer.class),
    MAINCOURSE(enums.menu.Food.MainCourse.class),
    DESSERT(enums.menu.Food.Dessert.class),
    COFFEE(enums.menu.Food.Coffee.class);

    private final enums.menu.Food[] values;

    Course(Class<? extends enums.menu.Food> kind) {
        values = kind.getEnumConstants();
    }

    public enums.menu.Food randomSelection() {
        return onjava.Enums.random(values);
    }
}
