// concurrent/Breakable.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Breakable {

    String id;
    private int failCount;

    public Breakable(String id, int failCount) {
        this.id = id;
        this.failCount = failCount;
    }

    @Override
    public String toString() {
        return "Breakable_" + id + " [" + failCount + "]";
    }

    public static Breakable work(Breakable b) {
        if (--b.failCount == 0) {
            System.out.println("Throwing Exception for " + b.id + "");
            throw new RuntimeException("Breakable_" + b.id + " failed");
        }
        System.out.println(b);
        return b;
    }
}
