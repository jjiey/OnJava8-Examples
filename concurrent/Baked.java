// concurrent/Baked.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import onjava.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * 制作蛋糕第二阶段
 * 单批面糊放入四个平底锅中烘烤
 */
public class Baked {

    static class Pan {
    }

    static Pan pan(Batter b) {
        new Nap(0.1);
        return new Pan();
    }

    /**
     * 加热 0.1ms
     */
    static Baked heat(Pan p) {
        new Nap(0.1);
        return new Baked();
    }

    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb) {
        return cfb.thenApplyAsync(Baked::pan)
                .thenApplyAsync(Baked::heat);
    }

    public static Stream<CompletableFuture<Baked>> batch() {
        CompletableFuture<Batter> batter = Batter.mix();
        return Stream.of(
                bake(batter),
                bake(batter),
                bake(batter),
                bake(batter)
        );
    }
}
