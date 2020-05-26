package MultiThread;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe.getAddress(1));

    }
}
