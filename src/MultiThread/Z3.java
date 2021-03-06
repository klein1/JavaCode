package MultiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Z3 {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println("cpu核心数:"+Runtime.getRuntime().availableProcessors());

        new Z3().show();

    }

    synchronized void show(){
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
