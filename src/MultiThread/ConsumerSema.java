package MultiThread;

import java.util.concurrent.Semaphore;

public class ConsumerSema {

    public static void main(String[] args) {

        DataSema data = new DataSema();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer2").start();

    }
}

class DataSema {
    private int num = 0;
    Semaphore produceCount = new Semaphore(5);
    Semaphore consumeCount = new Semaphore(0);
    Semaphore mute = new Semaphore(1);

    public void increment() throws InterruptedException {
        produceCount.acquire();
        mute.acquire();
        num++;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        mute.release();
        consumeCount.release();
    }

    public void decrease() throws InterruptedException {
        consumeCount.acquire();
        mute.acquire();
        num--;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        mute.release();
        produceCount.release();
    }
}