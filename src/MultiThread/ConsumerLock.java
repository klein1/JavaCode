package MultiThread;

import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerLock {

    public static void main(String[] args) {

        DataLock data = new DataLock(1);

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
    private Object[] num;
    private int capacity;
    private int size;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    DataLock(int capacity){
        this.capacity = capacity;
        num = new Object[capacity];
    }

    public void increment() {
        lock.lock();
        try {
            while (size >= capacity) {
                condition.await();
            }
            String content = UUID.randomUUID().toString();
            num[size++] = content;
            System.out.println(Thread.currentThread().getName() + "=>" + content);
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
            while (size == 0) {
                condition.await();
            }
            String content = num[--size].toString();
            System.out.println(Thread.currentThread().getName() + "=>" + content);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}