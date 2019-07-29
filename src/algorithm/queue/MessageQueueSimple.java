package algorithm.queue;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 实现简单消息队列
 */
public class MessageQueueSimple {
    private static final int MAX_SIZE = 100;
    private static MessageQueueSimple mq;
    private static ArrayBlockingQueue<Msg> queue = new ArrayBlockingQueue<>(MAX_SIZE);
    public static MessageQueueSimple getInstance() {
        mq = new MessageQueueSimple();
        return mq;
    }
    public void push(Msg msg) {
        try {
            queue.put(msg);
            System.out.println(msg.getContent() + " push success!");
        } catch (IllegalStateException e) {
            System.out.println("Maybe queue is full");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Msg take() {
        if (getSize() == 0) {
            System.out.println("nothing to take");
            return null;
        }
        Msg msg = null;
        try {
            msg = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public int getSize() {
        return queue.size();
    }
}

/**
 * 消息生产-消费测试
 */
class MsgPC {
    public static void main(String[] args) {
        new Producer().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Consumer().start();
    }
}

/**
 *  生产者类
 */
class Producer extends Thread {
    private MessageQueueSimple mq = MessageQueueSimple.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            String content = "msg_" + i;
            String timestamp = System.currentTimeMillis() + "";
            Msg msg = new Msg(content, timestamp);
            mq.push(msg);
        }
    }
}

/**
 *  消费者类
 */
class Consumer extends Thread {
    private MessageQueueSimple mq = MessageQueueSimple.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 201; i++) {
            Msg msg = mq.take();
            printMsg(msg);
        }
    }

    private void printMsg(Msg msg) {
        if (msg == null) {
            return;
        }
        System.out.println( msg.getContent() + " consume success");
    }
}

/**
 *  消息实体类
 */
class Msg {
    private String content;
    private String timestamp;
    public Msg(String c, String t) {
        this.content = c;
        this.timestamp = t;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
