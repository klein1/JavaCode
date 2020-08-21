package MultiThread;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Z1 {
    public static void main(String[] args) {
        Z1Task task = new Z1Task();

        Thread a = new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    task.taskA(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        Thread b = new Thread(() -> {
            try {
                for (int i = 0; i < 1; i++) {
                    task.taskB(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");

        Thread c = new Thread(() -> {
            try {
                for (int i = 0; i < 1; i++) {
                    task.taskC(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");

//        a.setDaemon(true);
//        b.setDaemon(true);
//        c.setDaemon(true);

        a.start();
        b.start();
        c.start();

//        Scanner sc = new Scanner(System.in);
//        sc.nextLine();
    }
}

class Z1Task {
    private int state = 1;

    synchronized public void taskA(int i) throws InterruptedException {
        System.out.println("执行A");
        while (state != 1)
            this.wait();
        System.out.println("A");
        state = 2;
        this.notifyAll();
    }

    synchronized public void taskB(int i) throws InterruptedException {
        System.out.println("执行B");
        while (state != 2) {
            this.wait();
//            TimeUnit.SECONDS.sleep(3);
        }
        System.out.println("L");
        state = 3;
        this.notifyAll();
    }

    synchronized public void taskC(int i) throws InterruptedException {
        System.out.println("执行C");
        while (state != 3) {
            this.wait();
//            TimeUnit.SECONDS.sleep(3);
        }

        System.out.println("I");
        state = 1;
//            TimeUnit.SECONDS.sleep(3);
        this.notifyAll();
    }
}
