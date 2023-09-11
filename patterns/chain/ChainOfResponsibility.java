// patterns/chain/ChainOfResponsibility.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java patterns.chain.ChainOfResponsibility}
package patterns.chain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

interface Algorithm {

    patterns.chain.Result algorithm(List<Double> line);
}

class FindMinima {

    public static patterns.chain.Result test(boolean success, String id, double d1, double d2) {
        System.out.println(id);
        if (success) {
            // Actual test/calculation here
            return new patterns.chain.Result(Arrays.asList(d1, d2));
        } else {
            // Try the next one in the chain:
            return patterns.chain.Result.FAIL;
        }
    }

    public static patterns.chain.Result leastSquares(List<Double> line) {
        return test(false, "LeastSquares", 1.1, 2.2);
    }

    public static patterns.chain.Result perturbation(List<Double> line) {
        return test(false, "Perturbation", 3.3, 4.4);
    }

    public static patterns.chain.Result bisection(List<Double> line) {
        return test(true, "Bisection", 5.5, 6.6);
    }

    static List<Function<List<Double>, patterns.chain.Result>> algorithms = Arrays.asList(
            FindMinima::leastSquares,
            FindMinima::perturbation,
            FindMinima::bisection
    );

    public static patterns.chain.Result minima(List<Double> line) {
        for (Function<List<Double>, patterns.chain.Result> alg : algorithms) {
            patterns.chain.Result result = alg.apply(line);
            if (result.success) {
                return result;
            }
        }
        return patterns.chain.Result.FAIL;
    }
}

public class ChainOfResponsibility {

    public static void main(String[] args) {
        FindMinima solver = new FindMinima();
        List<Double> line = Arrays.asList(1.0, 2.0, 1.0, 2.0, -1.0, 3.0, 4.0, 5.0, 4.0);
        patterns.chain.Result result = solver.minima(line);
        if (result.success) {
            System.out.println(result.line);
        } else {
            System.out.println("No algorithm found");
        }
    }
}
/* Output:
LeastSquares
Perturbation
Bisection
[5.5, 6.6]
*/
