import java.util.*;

public class Queue {
    List<Topic> topics;
    Map<Topic, List<MessageConsumer>> map=new HashMap<>();
    Queue(){
        topics=new ArrayList<>();
    }
    void addTopic(Topic topic){
        topics.add(topic);
        map.put(topic,new ArrayList<MessageConsumer>());
    }

    void addMessageConsumer(Topic topic,MessageConsumer MessageConsumer){
        map.get(topic).add(MessageConsumer);
    }

    void removeMessageConsumer(Topic topic,MessageConsumer MessageConsumer){
        map.get(topic).remove(MessageConsumer);
    }

    void addMessage(Topic topic,String message){
        topic.addMessage(message);
    }
}
