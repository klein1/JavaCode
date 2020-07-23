package MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Tools {
    static ReentrantLock lock = new ReentrantLock();

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
//                    lock.wait();
                    TimeUnit.SECONDS.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();

    }
}

