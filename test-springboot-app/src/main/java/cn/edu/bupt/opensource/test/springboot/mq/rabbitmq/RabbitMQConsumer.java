package cn.edu.bupt.opensource.test.springboot.mq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ 消费者
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class RabbitMQConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void consumeDirectExchange(String context) {
        log.info("消息消费者：" + context);
    }

    @RabbitListener(queues = "fanout.A")
    @RabbitHandler
    public void consumeFanoutExchangeA(String context) {
        log.info("消息消费者：" + context);
    }

    @RabbitListener(queues = "fanout.B")
    @RabbitHandler
    public void consumeFanoutExchangeB(String context) {
        log.info("消息消费者：" + context);
    }

    @RabbitListener(queues = "fanout.C")
    @RabbitHandler
    public void consumeFanoutExchangeC(String context) {
        log.info("消息消费者：" + context);
    }

    @RabbitListener(queues = "topic.message2")
    @RabbitHandler
    public void consumeTopicExchange(String context) {
        log.info("消息消费者：" + context);
    }

}
