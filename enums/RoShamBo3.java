// enums/RoShamBo3.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using constant-specific methods
// {java enums.RoShamBo3}
package enums;

import static enums.Outcome.DRAW;
import static enums.Outcome.LOSE;
import static enums.Outcome.WIN;

/**
 * “石头、剪刀、布”
 * 使用 enum 常量方法多路分发
 *
 * 缺点：改动多，不合理，不如 {@link enums.RoShamBo2}
 *
 * @see enums.RoShamBo1
 * @see enums.RoShamBo2
 * @see enums.RoShamBo4
 * @see enums.RoShamBo5
 * @see enums.RoShamBo6
 */
public enum RoShamBo3 implements enums.Competitor<RoShamBo3> {
    PAPER {
        @Override
        public enums.Outcome compete(RoShamBo3 it) {
            switch (it) {
                default: // To placate the compiler
                case PAPER:
                    return DRAW;
                case SCISSORS:
                    return LOSE;
                case ROCK:
                    return WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public enums.Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return WIN;
                case SCISSORS:
                    return DRAW;
                case ROCK:
                    return LOSE;
            }
        }
    },
    ROCK {
        @Override
        public enums.Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };

    @Override
    public abstract enums.Outcome compete(RoShamBo3 it);

    public static void main(String[] args) {
        enums.RoShamBo.play(RoShamBo3.class, 20);
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
