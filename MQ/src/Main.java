public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Queue queue = new Queue();
        Topic topic=new Topic("topic-1");
        queue.addTopic(topic);
        MessageConsumer msg1=new MessageConsumer("consumer-1",topic);
        topic.addMessageConsumer(msg1);
        MessageConsumer msg2=new MessageConsumer("consumer-2",topic);
        topic.addMessageConsumer(msg2);
        topic.addMessage("hello evveryone");

    }
}