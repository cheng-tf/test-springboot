package cn.edu.bupt.opensource.test.springboot.mq;

import cn.edu.bupt.opensource.test.springboot.mq.kafka.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Kafka 测试类
 * @author chengtf
 * @date 2019/4/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {

    @Autowired
    private KafkaProducer producer;

    // 发送消息
    @Test
    public void send() {
        producer.send();
    }

}
