// concurrent/CompletableApplyChained.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import onjava.Timer;

import java.util.concurrent.CompletableFuture;

public class CompletableApplyChained {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture.completedFuture(new Machina(0))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);
        System.out.println(timer.duration());
    }
}
/* Output:
Machina0: ONE
Machina0: TWO
Machina0: THREE
Machina0: complete
521
*/
