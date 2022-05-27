// concurrent/FrostedCake.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import onjava.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * 制作蛋糕第三阶段
 * 对蛋糕进行糖化
 */
final class Frosting {

    private Frosting() {
    }

    static CompletableFuture<Frosting> make() {
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Frosting());
    }
}

/**
 * 制作糖霜蛋糕
 */
public class FrostedCake {

    public FrostedCake(Baked baked, Frosting frosting) {
        new Nap(0.1);
    }

    @Override
    public String toString() {
        return "FrostedCake";
    }

    public static void main(String[] args) {
        Baked.batch().forEach(baked ->
                baked.thenCombineAsync(Frosting.make(), FrostedCake::new)
                        .thenAcceptAsync(System.out::println)
                        .join());
    }
}
