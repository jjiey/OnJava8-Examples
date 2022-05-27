// enums/RoShamBo5.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Multiple dispatching using an EnumMap of EnumMaps
// {java enums.RoShamBo5}
package enums;

import java.util.EnumMap;

import static enums.Outcome.DRAW;
import static enums.Outcome.LOSE;
import static enums.Outcome.WIN;

/**
 * 使用 EnumMap 进行分发
 *
 * @see enums.RoShamBo1
 * @see enums.RoShamBo2
 * @see enums.RoShamBo3
 * @see enums.RoShamBo4
 * @see enums.RoShamBo6
 */
enum RoShamBo5 implements enums.Competitor<RoShamBo5> {

    PAPER, SCISSORS, ROCK;

    private static final EnumMap<RoShamBo5, EnumMap<RoShamBo5, enums.Outcome>> TABLE = new EnumMap<>(RoShamBo5.class);

    static {
        for (RoShamBo5 it : RoShamBo5.values()) {
            TABLE.put(it, new EnumMap<>(RoShamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    /**
     * table K-V:
     *     PAPER:
     *         PAPER:DRAW
     *         SCISSORS:LOSE
     *         ROCK:WIN
     *     SCISSORS:
     *         PAPER:WIN
     *         SCISSORS:DRAW
     *         ROCK:LOSE
     *     ROCK:
     *         PAPER:LOSE
     *         SCISSORS:WIN
     *         ROCK:DRAW
     */
    private static void initRow(RoShamBo5 it, enums.Outcome vPAPER, enums.Outcome vSCISSORS, enums.Outcome vROCK) {
        EnumMap<RoShamBo5, enums.Outcome> row = RoShamBo5.TABLE.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    @Override
    public enums.Outcome compete(RoShamBo5 it) {
        return TABLE.get(this).get(it);
    }

    public static void main(String[] args) {
        enums.RoShamBo.play(RoShamBo5.class, 20);
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
