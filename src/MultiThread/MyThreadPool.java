package MultiThread;

import MultiThread.ThreadPools.PoolTask;

import java.util.LinkedList;

public class MyThreadPool {
    private final int initThreadCount;
    private final PoolWorker[] threadPool;
    private final LinkedList<Runnable> workerList;

    public MyThreadPool(int initThreadCount) {
        this.initThreadCount = initThreadCount;
        workerList = new LinkedList<>();
        threadPool = new PoolWorker[initThreadCount];
        for(int i=0;i<threadPool.length;i++)
        {
            threadPool[i]=new PoolWorker();
            threadPool[i].setName(i+"号线程");
            threadPool[i].start();
            System.out.println("---"+i+"号线程已经创建，在等待任务中");

        }
        System.out.println("***线程池初始化完毕***");
    }

    public void execute(Runnable worker){
        synchronized (workerList) {
            workerList.add(worker);
            workerList.notify();
            System.out.println("---加入了一个任务！！！");
        }
    }


    private class PoolWorker extends Thread {
        public void run(){
            Runnable r;
            while(true){
                synchronized (workerList) {
                    while(workerList.isEmpty()){
                        try {
                            workerList.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    r=(Runnable)workerList.removeFirst();
                }
                r.run();
            }
        }

    }

    public static void main(String[] args)
    {
        //10个任务给带有5个线程的线程池执行，每个任务就是数0到19，一个线程要把一个任务执行结束才去执行下一个任务
        MyThreadPool wq=new MyThreadPool(2);
        for(int i=0;i<3;i++){
            final int task=i;
            wq.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"  is looping for task of " + task);
                }
            });
        }
    }

}
