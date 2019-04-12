package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ConcurrentQueues {
    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
    SynchronousQueue synchronousQueue = new SynchronousQueue();

}
