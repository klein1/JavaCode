package MultiThread;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 线程同步问题
 * synchronized volatile 的使用
 */
public class StopThread {
//    private static boolean stopRequested;
    private static volatile boolean stopRequested;
//    private static synchronized boolean isStopRequested() {
//        return stopRequested;
//    }
    private static boolean isStopRequested2() {
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException {
//        Thread backgroundThread = new Thread(() -> {
//            int i = 0;
//            while (!isStopRequested2()) {
//                i++;
//            }
//        });
//        backgroundThread.start();
////        TimeUnit.SECONDS.sleep(1);
//
//        Scanner sc = new Scanner(System.in);
//        String temp;
//        while (!(temp = sc.next()).equals("#")){
//            System.out.println(temp);
//        }
//        stopRequested = true;

        Thread safe = new ThreadSafe();
        safe.start();

        Thread.sleep(3000);
        System.out.println("interrupt...");
        safe.interrupt();

    }
}

class ThreadSafe extends Thread{
    public void run(){
        while(!isInterrupted()){
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
//                break;  //sleep阻塞跳出
                Thread.currentThread().interrupt();
            }
        }
    }
}