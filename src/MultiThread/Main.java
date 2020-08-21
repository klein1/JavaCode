package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Main {

    int value;

    public static void main(String[] args){
        Product p = new Product() {
            @Override
            public String getName() {
                return null;
            }
        };

        Prod p2 = new Prod(){
            @Override
            public String getName() {
                return "name";
            }
        };
        System.out.println(p2.getName());

        Callable callable = new MyCallable("callable");
        Runnable runnable = new MyRunnable("runnable");
        Callable c = Executors.callable(runnable);

        for (int i = 0; i < 100; i++) {
//            new Thread(new Example()).start();
            new Example2().start();
        }

        for (int i = 0; i < 100; i++) {
            new Example2().start();
        }

        for (int i = 0; i < 100; i++) {
            new Example2().start();
        }

    }
}

interface Product {
    String getName();
}

class Prod{
    String getName(){
        return "";
    };
}

class Example implements Runnable{

    static int i = 0;

    @Override
    public void run() {
        System.out.println(i++);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Example2 extends Thread{

    static int i = 0;
    static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(i++);
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}