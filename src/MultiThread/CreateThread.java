package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class MyCallable implements Callable<String> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return this.name;
    }
}

public class CreateThread {

    public static void main(String[] args) throws Exception{

        // 通过Callable<Class>实现返回值
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable c = new MyCallable(i + " ");
            Future future = pool.submit(c);
            System.out.println("submit a callable thread: " + i);
            list.add(future);
        }

        pool.shutdown();

        for (Future future : list) {
            System.out.println("get the result from callable thread: " + future.get().toString());
        }


        // 线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running");
                }
            });
//            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        }

        threadPool.shutdown();

    }
}
