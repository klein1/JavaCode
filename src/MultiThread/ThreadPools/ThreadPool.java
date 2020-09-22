package MultiThread.ThreadPools;

public interface ThreadPool {

    void run();

    void excute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getMaxSize();

    int getQueSize();

    int getActiveCount();

    boolean isShutDown();
}
