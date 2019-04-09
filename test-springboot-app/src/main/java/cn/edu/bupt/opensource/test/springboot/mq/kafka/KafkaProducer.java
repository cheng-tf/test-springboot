package cn.edu.bupt.opensource.test.springboot.mq.kafka;

import cn.edu.bupt.opensource.test.springboot.domain.MessageEntity;
import cn.edu.bupt.opensource.test.springboot.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Kafka 生产者
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send() {
        try {
            MessageEntity message = new MessageEntity();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString());
            message.setSendTime(new Date());
            logger.info("message = {}", JacksonUtils.objectToJson(message));
            kafkaTemplate.send("test2", JacksonUtils.objectToJson(message));
            logger.info("Kafka发送消息成功.");
        } catch (Exception e) {
            logger.error("Kafka发送消息失败，error={}", e);
        }
    }


}
