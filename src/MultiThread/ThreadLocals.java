package MultiThread;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ThreadLocal
 */
public class ThreadLocals implements Runnable{
    Map map = new HashMap(); // Node<K,V>[]  —  Entry[]
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
    private static final ThreadLocal<String> formatter2 = new ThreadLocal<String>(){
        @Override
        protected String initialValue()
        {
            return "Hello";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocals obj = new ThreadLocals();
        for(int i=0 ; i<4; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

        System.out.println(formatter2.get());
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }

}