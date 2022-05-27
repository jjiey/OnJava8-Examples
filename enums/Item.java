// enums/Item.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package enums;

public interface Item {

    enums.Outcome compete(Item it);

    enums.Outcome eval(enums.Paper p);

    enums.Outcome eval(enums.Scissors s);

    enums.Outcome eval(enums.Rock r);
}
