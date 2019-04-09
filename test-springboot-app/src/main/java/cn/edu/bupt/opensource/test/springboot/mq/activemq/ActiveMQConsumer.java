package cn.edu.bupt.opensource.test.springboot.mq.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * ActiveMQ 消费者
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class ActiveMQConsumer {

    private static final Logger log = LoggerFactory.getLogger(ActiveMQConsumer.class);

    // 使用JmsListener配置消息消费者所监听的队列，message为接收到的消息
    @JmsListener(destination = "item-add-queue", containerFactory = "jmsListenerContainerTopic")
    public void consumeQueue(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            log.info("消息消费者：" + textMessage.getText());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "item-add-queue", containerFactory = "jmsListenerContainerTopic")
    public void consumeQueue2(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            log.info("消息消费者2：" + textMessage.getText());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @JmsListener(destination = "item-add-topic", containerFactory = "jmsListenerContainerTopic")
    public void consumeTopic(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            log.info("消息消费者：" + textMessage.getText());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "item-add-topic", containerFactory = "jmsListenerContainerTopic")
    public void consumeTopic2(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            log.info("消息消费者2：" + textMessage.getText());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
