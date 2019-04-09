package cn.edu.bupt.opensource.test.springboot.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Kafka 消费者
 * @author chengtf
 * @date 2019/4/9
 */
@Component
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"test2"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("record: " + record);
            logger.info("message: " + message);
            logger.info("key: " + record.key());
            logger.info("value: " + record.value().toString());
        }
    }

}
