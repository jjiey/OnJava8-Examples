// enums/Scissors.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package enums;

import static enums.Outcome.DRAW;
import static enums.Outcome.LOSE;
import static enums.Outcome.WIN;

public class Scissors implements enums.Item {

    @Override
    public enums.Outcome compete(enums.Item it) {
        return it.eval(this);
    }

    @Override
    public enums.Outcome eval(enums.Paper p) {
        return LOSE;
    }

    @Override
    public enums.Outcome eval(Scissors s) {
        return DRAW;
    }

    @Override
    public enums.Outcome eval(enums.Rock r) {
        return WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}
