// concurrent/Batter.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import onjava.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * 制作蛋糕第一阶段
 * 准备并将原料混合成面糊
 */
public class Batter {

    /**
     * 鸡蛋
     */
    static class Eggs {
    }

    /**
     * 牛奶
     */
    static class Milk {
    }

    /**
     * 糖
     */
    static class Sugar {
    }

    /**
     * 面粉
     */
    static class Flour {
    }

    /**
     * 花 0.1ms 准备
     */
    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture.completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());
        CompletableFuture.allOf(eggs, milk, sugar, flour).join();
        // Mixing time
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Batter());
    }
}
