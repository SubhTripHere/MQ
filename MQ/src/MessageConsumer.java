import java.util.concurrent.locks.ReentrantLock;

public class MessageConsumer implements Runnable{
    private String MessageConsumerName;
    private Integer offset;
    private Topic topic;
    ReentrantLock lock = new ReentrantLock();
    MessageConsumer(String MessageConsumerName,Topic topic){
        this.MessageConsumerName = MessageConsumerName;
        this.topic = topic;
        offset = 0;
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(offset>=topic.messages.size()){
                try {
                   lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(topic.messages.get(offset));
            offset++;
            lock.notifyAll();
        }
    }
}
