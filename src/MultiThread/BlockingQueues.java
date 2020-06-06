package MultiThread;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueues {
    public static void main(String[] args) {
        new ArrayBlockingQueue<String>(100,true);
    }
}
