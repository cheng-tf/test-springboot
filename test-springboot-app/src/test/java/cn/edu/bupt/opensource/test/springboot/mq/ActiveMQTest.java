package cn.edu.bupt.opensource.test.springboot.mq;

import cn.edu.bupt.opensource.test.springboot.mq.activemq.ActiveMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ActiveMQ 测试类
 * @author chengtf
 * @date 2019/4/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQTest {

    @Autowired
    private ActiveMQProducer producer;

    // 点对点消息模型
    @Test
    public void queue() throws Exception {
        producer.queueSend();
    }

    // 发布-订阅消息模型
    @Test
    public void topic() throws Exception {
        producer.topicSend();
    }

}
