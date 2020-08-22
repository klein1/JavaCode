package MultiThread;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * AQS ReentrantLock Semaphore CountDownLatch CyclicBarrier
 */
public class AQS {
//    private static Lock reentrantLock = new ReentrantLock();
    private static Lock reentrantLock = new ReentrantLock(true);
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->{
        System.out.println("end");
    });

    // 请求的数量
    private static final int threadCount = 10;

    public static void main(String[] args)  throws InterruptedException{
//        new Thread(() -> testReentrantLock(), "线程A").start();
//        new Thread(() -> testReentrantLock(), "线程B").start();

        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 一次只能允许执行的线程数量。
        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    semaphore.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
                    testSemaphore(threadnum);
//                    semaphore.release();// 释放一个许可
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            });
        }
        threadPool.shutdown();
        System.out.println("finish");

//        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
//        ExecutorService threadPool = Executors.newFixedThreadPool(300);
//        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
//        for (int i = 0; i < threadCount; i++) {
//            final int threadnum = i;
//            threadPool.execute(() -> {// Lambda 表达式的运用
//                try {
//                    testCountDownLatch(threadnum);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } finally {
//                    countDownLatch.countDown();// 表示一个请求已经被完成
//                }
//            });
//        }
//        countDownLatch.await();
//        threadPool.shutdown();
//        System.out.println("finish");

        // 创建线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < threadCount; i++) {
//            final int threadNum = i;
////            Thread.sleep(1000);
//            threadPool.execute(() -> {
//                try {
//                    testCyclicBarrier(threadNum);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            });
//        }
//        threadPool.shutdown();
    }

    public static void testReentrantLock(){
        try{
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally{
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            reentrantLock.unlock();
        }
    }

    public static void testSemaphore(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }

    public static void testCountDownLatch(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }

    public static void testCyclicBarrier(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        try {
            /**等待60秒，保证子线程完全执行结束*/
//            cyclicBarrier.await(60, TimeUnit.SECONDS);
            cyclicBarrier.await();
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadnum + "is finish");
    }


}

