// enums/Input.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Random;

/**
 * 自动售贷机 10 种输入
 */
public enum Input {

    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.

        @Override
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    /**
     * In cents
     */
    int value;

    Input() {
    }

    Input(int value) {
        this.value = value;
    }

    /**
     * In cents
     */
    int amount() {
        return this.value;
    }

    static Random rand = new Random(47);

    public static Input randomSelection() {
        // 因为不包含 STOP，所以 VendingMachine 程序永远不会终止。可以起到健全测试（sanity test）的作用
        // Don't include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}
