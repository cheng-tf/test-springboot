package cn.edu.bupt.opensource.test.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 * @author chengtf
 * @date 2019/4/10
 */
@Configuration
public class RabbitMQConfig {

    // ------------------------------Direct 交换器（默认交换器）--------------------------------
    // 队列自动绑定到默认Direct交换器，且默认以队列名称作为路由键。
    /*@Bean
    public Queue Queue() {
        return new Queue("hello");
    }*/


    // ---------------------------------Fanout 交换器-------------------------------------
    // 当消息到达时，Fanout交换器会将消息投递给所有附加到本身的队列
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }


    // ---------------------------------Topic 交换器-------------------------------------
    // 当不同源头的消息到达时，Topic交换器可使得消息到达同一个队列
    final static String message = "topic.message";
    final static String message2 = "topic.message2";

    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitMQConfig.message);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(RabbitMQConfig.message2);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage2).to(topicExchange).with("topic.#");
    }

}
