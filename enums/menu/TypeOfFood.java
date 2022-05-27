// enums/menu/TypeOfFood.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java enums.menu.TypeOfFood}
package enums.menu;

import static enums.menu.Food.Appetizer;
import static enums.menu.Food.Coffee;
import static enums.menu.Food.Dessert;
import static enums.menu.Food.MainCourse;

public class TypeOfFood {

    public static void main(String[] args) {
        enums.menu.Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
}
