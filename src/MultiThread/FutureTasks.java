package MultiThread;

import java.util.concurrent.FutureTask;

public class FutureTasks {

    public static void main(String[] args) throws Exception{
        FutureTask futureTask = new FutureTask(()->{
            System.out.println("running");
            return "result";
        });
        new Thread(futureTask, "A").start();
        System.out.println(futureTask.get());

        FutureTasks tasks = new FutureTasks();
        Data data = tasks.new Data();
        FutureTask futureTask2 = new FutureTask(tasks.new MyThread(data), data);
        new Thread(futureTask2, "B").start();
        System.out.println(((Data)futureTask2.get()).s);

    }

    class Data{
        String s = "result";
    }

    class MyThread implements Runnable{
        Data data;

        MyThread(Data data){
            this.data = data;
        }

        @Override
        public void run() {
            System.out.println("running2");
            data.s += ": success";
        }
    }
}