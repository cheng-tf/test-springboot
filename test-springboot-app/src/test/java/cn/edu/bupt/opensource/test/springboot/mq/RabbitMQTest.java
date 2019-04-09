package cn.edu.bupt.opensource.test.springboot.mq;

import cn.edu.bupt.opensource.test.springboot.mq.rabbitmq.RabbitMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ 测试类
 * @author chengtf
 * @date 2019/4/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitMQProducer producer;

    // Direct交换器模式
    @Test
    public void directExchange() throws Exception {
        producer.directExchangeSend();
    }

    // Fanout交换器模式
    @Test
    public void fanoutExchange() throws Exception {
           producer.fanoutExchangeSend();
    }

    // Topic交换器模式
    @Test
    public void topicExchange() throws Exception {
        producer.topicExchangeSend();
        producer.topicExchangeSend2();
    }



}
