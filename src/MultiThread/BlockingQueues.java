package MultiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueues {
    public static void main(String[] args) {
        new ArrayBlockingQueue<String>(100,true);
    }
}
