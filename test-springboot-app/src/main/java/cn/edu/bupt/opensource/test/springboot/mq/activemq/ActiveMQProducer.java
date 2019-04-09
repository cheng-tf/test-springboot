package cn.edu.bupt.opensource.test.springboot.mq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * ActiveMQ 生产者
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class ActiveMQProducer {

    private static final Logger log = LoggerFactory.getLogger(ActiveMQProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void queueSend() {
        jmsTemplate.send(new ActiveMQQueue("item-add-quque"), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                log.info("消息发送者：536563");
                return session.createTextMessage("536563");
            }
        });
    }

    public void topicSend() {
        jmsTemplate.send(new ActiveMQTopic("item-add-topic"), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                log.info("消息发送者：536563");
                return session.createTextMessage("536563");
            }
        });
    }


}
