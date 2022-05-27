// concurrent/Summing2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ExcludeFromTravisCI}

import java.util.Arrays;

public class Summing2 {

    static long basicSum(long[] ia) {
        long sum = 0;
        for (long l : ia) {
            sum += l;
        }
        return sum;
    }

    // Approximate largest value of SZ before
    // running out of memory on my machine:
    public static final int SZ = 20_000_000;
    public static final long CHECK = SZ * ((long) SZ + 1) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        long[] la = new long[SZ + 1];
        // 从 0 开始填充数组 la
        Arrays.parallelSetAll(la, i -> i);

        Summing.timeTest("Array Stream Sum", CHECK, () ->
                Arrays.stream(la).sum());
        Summing.timeTest("Parallel", CHECK, () ->
                Arrays.stream(la).parallel().sum());
        Summing.timeTest("Basic Sum", CHECK, () ->
                basicSum(la));
        // Destructive summation:
        Summing.timeTest("parallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });
//        long[] la = new long[Summing3.SZ + 1];
//        Arrays.parallelSetAll(la, i -> i);
//        System.out.println(1);
    }
}
/* Output:
200000010000000
Array Stream Sum: 166ms
Parallel: 30ms
Basic Sum: 45ms
parallelPrefix: 53ms
*/
