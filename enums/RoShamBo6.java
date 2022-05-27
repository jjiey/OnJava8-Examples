// enums/RoShamBo6.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Enums using "tables" instead of multiple dispatch
// {java enums.RoShamBo6}
package enums;

import static enums.Outcome.DRAW;
import static enums.Outcome.LOSE;
import static enums.Outcome.WIN;

/**
 * 使用二维数组
 *
 * TABLE 与 {@link enums.RoShamBo5} 中 initRow() 方法的调用次序完全相同
 *
 * 优点：最简洁、最直接、最快速
 *
 * @see enums.RoShamBo1
 * @see enums.RoShamBo2
 * @see enums.RoShamBo3
 * @see enums.RoShamBo4
 * @see enums.RoShamBo5
 */
enum RoShamBo6 implements enums.Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static final enums.Outcome[][] TABLE = {
            {DRAW, LOSE, WIN}, // PAPER
            {WIN, DRAW, LOSE}, // SCISSORS
            {LOSE, WIN, DRAW}, // ROCK
    };

    @Override
    public enums.Outcome compete(RoShamBo6 other) {
        return TABLE[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        enums.RoShamBo.play(RoShamBo6.class, 20);
    }
}
/* Output:
ROCK vs. ROCK: DRAW
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
PAPER vs. SCISSORS: LOSE
PAPER vs. PAPER: DRAW
PAPER vs. SCISSORS: LOSE
ROCK vs. SCISSORS: WIN
SCISSORS vs. SCISSORS: DRAW
ROCK vs. SCISSORS: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
ROCK vs. PAPER: LOSE
ROCK vs. SCISSORS: WIN
SCISSORS vs. ROCK: LOSE
PAPER vs. SCISSORS: LOSE
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
*/
