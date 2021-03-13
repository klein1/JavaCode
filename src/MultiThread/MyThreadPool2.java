package MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

interface ThreadPool2<Job extends Runnable> {
    // 启动
    void execute(Job job);

    // 关闭
    void shutDown();

    // 增加线程
    void addWorkThread(int num);

    // 减少线程
    void reduceWorkThread(int num) throws Exception;

    // 正在执行的线程数
    int getSize();

}

public class MyThreadPool2<Job extends Runnable> implements ThreadPool2<Job> {
    /**
     * 最大线程数
     */
    private static final int MAX_WORK_THREAD = 10;
    /**
     * 最小线程数
     */
    private static final int MIN_WORK_THREAD = 1;
    /**
     * 默认的线程数
     */
    private static final int DEFAULT_WORK_THREAD = 5;

    /**
     * 工作列表（无序）
     */
    private final LinkedList<Job> jobQueue = new LinkedList<>();

    /**
     * 工作者线程
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    /**
     * 工作线程数
     */
    private int workerNum = DEFAULT_WORK_THREAD;

    /**
     * 线程编号
     */
    private AtomicLong threadNum = new AtomicLong();

    public MyThreadPool2() {
        initWorks(DEFAULT_WORK_THREAD);
    }

    public MyThreadPool2(int num) {
        if (num > MAX_WORK_THREAD) {
            workerNum = MAX_WORK_THREAD;
        } else if (workerNum < MIN_WORK_THREAD) {
            workerNum = MIN_WORK_THREAD;
        } else {
            workerNum = num;
        }
        initWorks(workerNum);
    }

    /**
     * 初始化工作线程
     *
     * @param num
     */
    private void initWorks(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread =
                    new Thread(worker, "THPOLL-WORKER-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {

        if (job != null) {
            synchronized (jobQueue) {
                // 加入工作线程队列
                jobQueue.add(job);

                // 尝试唤醒线程
                jobQueue.notify();
            }

        }
    }

    @Override
    public void shutDown() {
        // 线程关闭循环
        for (Worker worker : workers) {
            worker.shutDown();
        }
        // 全部唤醒
        synchronized (jobQueue) {
            jobQueue.notifyAll();
        }
    }

    @Override
    public void addWorkThread(int num) {
        synchronized (jobQueue) {
            if (num + this.workerNum > MAX_WORK_THREAD) {
                num = MAX_WORK_THREAD - this.workerNum;
            }
            initWorks(num);
            this.workerNum += num;
        }
    }

    @Override
    public void reduceWorkThread(int num) throws Exception {
        synchronized (jobQueue) {
            if (num >= this.workerNum) {
                throw new Exception();
            }
            int count = num;
            int succCount = 0;
            while (count > 0) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutDown();
                    count--;
                    succCount++;
                }
            }
            this.workerNum -= succCount;
        }

    }

    @Override
    public int getSize() {
        return jobQueue.size();
    }

    private class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobQueue) {
                    while (jobQueue.isEmpty() && running) {
                        try {
                            jobQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if (!jobQueue.isEmpty()) {
                        job = jobQueue.removeFirst();
                    }
                }
                // 如果此时线程池已经被关闭，则忽略所有任务
                // 现实情况可能有其他操作
                if (job != null && running) {
                    try {
                        job.run();
                        System.out.println("JOB=" + Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void shutDown() {
            running = false;
        }
    }
}