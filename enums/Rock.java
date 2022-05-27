// enums/Rock.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package enums;

import static enums.Outcome.DRAW;
import static enums.Outcome.LOSE;
import static enums.Outcome.WIN;

public class Rock implements enums.Item {

    @Override
    public enums.Outcome compete(enums.Item it) {
        return it.eval(this);
    }

    @Override
    public enums.Outcome eval(enums.Paper p) {
        return WIN;
    }

    @Override
    public enums.Outcome eval(enums.Scissors s) {
        return LOSE;
    }

    @Override
    public enums.Outcome eval(Rock r) {
        return DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
