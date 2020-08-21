package MultiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Z2 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(3);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        new Thread(()-> {
            while (true){
                try {
                    Thread.sleep(300);
                    long time = System.currentTimeMillis();
                    arrayBlockingQueue.put(time);
                    System.out.println("put object" + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true){
            try {
                Thread.sleep(1000);
                long time = (long) arrayBlockingQueue.take();
                System.out.println("get object:" + time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
