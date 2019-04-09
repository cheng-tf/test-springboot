package cn.edu.bupt.opensource.test.springboot.mq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ 生产者
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class RabbitMQProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 使用Direct交换器（默认）发送消息
     */
    public void directExchangeSend() {
        String context = "Hello, Direct message!";
        log.info("消息生产者：" + context);
        // 发送消息：参数1-路由键，参数2-消息内容
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    /**
     * 使用Fanout交换器发送消息
     */
    public void fanoutExchangeSend() {
        String context = "Hi, Fanout message!";
        log.info("消息生产者：" + context);
        // 发送消息：参数1-交换器，参数2-路由键，参数3-消息内容
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

    /**
     * 使用Topic交换器发送消息
     */
    public void topicExchangeSend() {
        String context = "Hi, Topic message1 !";
        System.out.println("消息生产者：" + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void topicExchangeSend2() {
        String context = "Hi, Topic messages2 !";
        System.out.println("消息生产者：" + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }

}
