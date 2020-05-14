package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * 线程同步问题
 * synchronized volatile 的使用
 */
public class StopThread {
    private static boolean stopRequested;
//    private static volatile boolean stopRequested;
    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }
    private static boolean isStopRequested2() {
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!isStopRequested2()) {
                    i++;
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
