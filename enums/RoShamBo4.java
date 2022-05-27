// enums/RoShamBo4.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java enums.RoShamBo4}
package enums;

/**
 * “石头、剪刀、布”
 * 使用 enum 常量方法多路分发
 * 压缩简化 {@link enums.RoShamBo3}
 *
 * 缺点：难理解
 *
 * @see enums.RoShamBo1
 * @see enums.RoShamBo2
 * @see enums.RoShamBo3
 * @see enums.RoShamBo5
 * @see enums.RoShamBo6
 */
public enum RoShamBo4 implements enums.Competitor<RoShamBo4> {
    ROCK {
        @Override
        public enums.Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        @Override
        public enums.Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    PAPER {
        @Override
        public enums.Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };

    enums.Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return (opponent == this) ? enums.Outcome.DRAW
                : ((opponent == loser) ? enums.Outcome.WIN
                : enums.Outcome.LOSE);
    }

    public static void main(String[] args) {
        enums.RoShamBo.play(RoShamBo4.class, 20);
    }
}
/* Output:
PAPER vs. PAPER: DRAW
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
ROCK vs. SCISSORS: WIN
ROCK vs. ROCK: DRAW
ROCK vs. SCISSORS: WIN
PAPER vs. SCISSORS: LOSE
SCISSORS vs. SCISSORS: DRAW
PAPER vs. SCISSORS: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
PAPER vs. ROCK: WIN
PAPER vs. SCISSORS: LOSE
SCISSORS vs. PAPER: WIN
ROCK vs. SCISSORS: WIN
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
*/
