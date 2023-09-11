// patterns/ProxyDemo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Basic demonstration of the Proxy pattern.

interface ProxyBase {

    void f();

    void g();

    void h();
}

class Proxy implements ProxyBase {

    private final ProxyBase implementation = new Implementation();

    // Pass method calls to the implementation:
    @Override
    public void f() {
        implementation.f();
    }

    @Override
    public void g() {
        implementation.g();
    }

    @Override
    public void h() {
        implementation.h();
    }
}

class Implementation implements ProxyBase {

    @Override
    public void f() {
        System.out.println("Implementation.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation.h()");
    }
}

/**
 * 代理模式
 *
 * 代理模式只是桥接模式的一种特殊情况
 *
 * 在结构上，代理模式和桥接模式的区别：代理模式只有一个实现，而桥接模式有多个实现
 * 在设计模式中被认为是不同的:代理模式用于控制对其实现的访问，而桥接模式允许动态更改实现
 * 但是，如果扩展了“控制对实现的访问”的概念，那么这两者就可以完美地结合在一起
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Proxy p = new Proxy();
        p.f();
        p.g();
        p.h();
    }
}
/* Output:
Implementation.f()
Implementation.g()
Implementation.h()
*/
