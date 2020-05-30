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

    public static void main(String[] args) throws Exception {

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


        // 通过线程池
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

        // 通过FutureTask
        Callable myTask = new MyCallable("myTask");
        FutureTask<Object> futureTask = new FutureTask<>(myTask);//将任务放进FutureTask里
        //采用thread来开启多线程，futuretask继承了Runnable，可以放在线程池中来启动执行
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            //get():获取任务执行结果，如果任务还没完成则会阻塞等待直到任务执行完成。如果任务被取消则会抛出CancellationException异常，
            //如果任务执行过程发生异常则会抛出ExecutionException异常，如果阻塞等待过程中被中断则会抛出InterruptedException异常。
            String result = (String) futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
