package MultiThread;

public class ConsumerSync {

    public static void main(String[] args) {

        DataSync data = new DataSync();

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

class DataSync {
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        this.notifyAll();
    }
}