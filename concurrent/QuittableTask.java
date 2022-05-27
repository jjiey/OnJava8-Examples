// concurrent/QuittableTask.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import onjava.Nap;

import java.util.concurrent.atomic.AtomicBoolean;

public class QuittableTask implements Runnable {

    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private final AtomicBoolean running = new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        // [1]
        while (running.get()) {
            new Nap(0.1);
        }
        // [2]
        System.out.print(id + " ");
    }
}
