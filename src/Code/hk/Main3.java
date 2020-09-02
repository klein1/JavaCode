package Code.hk;

import java.util.concurrent.atomic.AtomicInteger;

public class Main3 {
    static AtomicInteger i = new AtomicInteger(9);

    public static void main(String[] args) {

        new Thread(()->{
            while(i.get() > 0){
                i.getAndDecrement();
                System.out.println(Thread.currentThread().getName());
            }
        }, "Thread1").start();

        new Thread(()->{
            while(i.get() > 0){
                i.getAndDecrement();
                System.out.println(Thread.currentThread().getName());
            }
        }, "Thread2").start();

        new Thread(()->{
            while(i.get() > 0){
                i.getAndDecrement();
                System.out.println(Thread.currentThread().getName());
            }
        }, "Thread3").start();


        while (i.get()!=0);
        System.out.println("数字为0，结束递减");
    }
}
