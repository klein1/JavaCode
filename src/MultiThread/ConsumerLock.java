package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerLock {

    public static void main(String[] args) {

        DataLock data = new DataLock();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "Producer1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrease();
            }
        }, "Consumer1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "Producer2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrease();
            }
        }, "Consumer2").start();

    }
}

class DataLock {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "=>" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease(){
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "=>" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}