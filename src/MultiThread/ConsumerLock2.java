package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerLock2 {

    public static void main(String[] args) {

        DataLock2 data = new DataLock2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA(i);
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB(i);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC(i);
            }
        }, "C").start();
    }
}

class DataLock2 {
    private int state = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA(int i){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "=>" + i + " get lock");
            while(state != 1)
                condition1.await();
            System.out.println(Thread.currentThread().getName() + "=>" + "AAA");
            state = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(int i){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "=>" + i + " get lock");
            while(state != 2)
                condition2.await();
            System.out.println(Thread.currentThread().getName() + "=>" + "BBB");
            state = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(int i){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "=>" + i + " get lock");
            while(state != 3)
                condition3.await();
            System.out.println(Thread.currentThread().getName() + "=>" + "CCC");
            state = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}