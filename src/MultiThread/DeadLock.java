package MultiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁
 */
public class DeadLock {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
//        testSync();
        testReen();
    }

    public static void testSync(){
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2").start();
    }

    public static void testReen(){
        long time = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            try {
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，获取lock1锁");
                Thread.sleep(1000);
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，获取lock2锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock1.isHeldByCurrentThread())
                    lock1.unlock();
                if(lock2.isHeldByCurrentThread())
                    lock2.unlock();
                System.out.println(Thread.currentThread().getName() + "，退出！");
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，获取lock2锁");
                Thread.sleep(1000);
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，获取lock1锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock1.isHeldByCurrentThread())
                    lock1.unlock();
                if(lock2.isHeldByCurrentThread())
                    lock2.unlock();
                System.out.println(Thread.currentThread().getName() + "，退出！");
            }
        });
        thread2.start();

        while(true){
            if(System.currentTimeMillis() - time >= 3000){
                thread2.interrupt();
            }
        }
    }
}
