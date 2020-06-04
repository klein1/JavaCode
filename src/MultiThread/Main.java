package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
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