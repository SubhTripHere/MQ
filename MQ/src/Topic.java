import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Topic {
    private String topicName;
    List<String> messages;
    List<MessageConsumer> MessageConsumerList;
    ReentrantLock lock=new ReentrantLock();

    public Topic(String topicName) {
        this.topicName = topicName;
        messages = new ArrayList<>();
        MessageConsumerList=new ArrayList<MessageConsumer>();
    }
    void addMessage(String message) {
        messages.add(message);
        for(MessageConsumer messageConsumer:MessageConsumerList) {
            new Thread(messageConsumer).start();
        }
    }

    public void addMessageConsumer(MessageConsumer MessageConsumer) {
        MessageConsumerList.add(MessageConsumer);
    }

    public void readMessage(){

    }

    public void removeMessageConsumer(MessageConsumer MessageConsumer) {
        MessageConsumerList.remove(MessageConsumer);
    }
}
