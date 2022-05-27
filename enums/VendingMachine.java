// enums/VendingMachine.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java VendingMachine VendingMachineInput.txt}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 自动售货机 Input 分类
 */
enum Category {
    /**
     * 用户塞入钞票
     */
    MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
    /**
     * 选择了某个货物
     */
    ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS, Input.SODA, Input.SOAP),
    /**
     * 操作被取消
     */
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    /**
     * 机器停止
     */
    SHUT_DOWN(Input.STOP);

    private final Input[] values;

    Category(Input... types) {
        this.values = types;
    }

    private static final EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.values) {
                categories.put(type, c);
            }
        }
    }

    /**
     * 根据自动售货机的 Input 获取对应的 类别
     */
    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

public class VendingMachine {

    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    /**
     * Tagging enum
     * 用来标记 State 枚举的瞬时状态
     */
    enum StateDuration {
        TRANSIENT
    }

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        /**
         * 手动变回 RESTING
         */
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            @Override
            void output() {
                System.out.println("Halted");
            }
        };

        /**
         * 瞬时状态
         */
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }

        void next(Input input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }

        void output() {
            System.out.println(amount);
        }
    }

    static void run(Supplier<Input> gen) {
        while (state != State.TERMINAL) {
            Input input = gen.get();
            state.next(input);
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Supplier<Input> gen = new RandomInputSupplier();
        if (args.length == 1) {
            gen = new FileInputSupplier(args[0]);
        }
        run(gen);
    }
}

// For a basic sanity check:
class RandomInputSupplier implements Supplier<Input> {

    @Override
    public Input get() {
        return Input.randomSelection();
    }
}

// Create Inputs from a file of ';'-separated strings:
class FileInputSupplier implements Supplier<Input> {

    private final Iterator<String> input;

    FileInputSupplier(String fileName) {
        try {
            input = Files.lines(Paths.get(fileName))
                    .skip(1) // Skip the comment line
                    .flatMap(s -> Arrays.stream(s.split(";")))
                    .map(String::trim)
                    .collect(Collectors.toList())
                    .iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Input get() {
        if (!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
/* Output:
25
50
75
here is your CHIPS
0
100
200
here is your TOOTHPASTE
0
25
35
Your change: 35
0
25
35
Insufficient money for SODA
35
60
70
75
Insufficient money for SODA
75
Your change: 75
0
Halted
*/
