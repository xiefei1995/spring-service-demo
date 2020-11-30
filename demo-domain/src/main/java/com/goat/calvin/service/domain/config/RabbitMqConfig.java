package com.goat.calvin.service.domain.config;//package com.goat.calvin.apache.service.sharding.domain.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> rabbitMq 配置文件<p/>
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/16 15:38
 */
@Configuration
public class RabbitMqConfig {
    public static final String BASE_EXCHANGE = "base_exchange";
    public static final String BASE_QUEUE = "base_queue";
    public static final String BASE_ROUTINGKEY = "base_routing";

    public static final String BASE_DELAY_EXCHANGE = "base_delay_exchange";
    public static final String BASE_DELAY_QUEUE = "base_delay_queue";
    public static final String BASE_DELAY_ROUTINGKEY = "base_delay_routing";

    public static final String BASE_TOPIC_EXCHANGE = "base_topic_exchange";
    public static final String BASE_TOPIC_QUEUE = "base_topic_queue";
    public static final String BASE_TOPIC_ROUTINGKEY = "base_topic_routing";


    /** 普通消息队列 */
    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.directExchange(BASE_EXCHANGE).durable(true).build();
    }

    @Bean
    public Queue queue(){
        return QueueBuilder.durable(BASE_QUEUE).build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(BASE_ROUTINGKEY).noargs();
    }

    /** 延时消息队列 */
    @Bean
    public Exchange delayExchange(){
        return ExchangeBuilder.directExchange(BASE_DELAY_EXCHANGE).durable(true).build();
    }

    @Bean
    public Queue delayQueue(){
        return QueueBuilder.durable(BASE_QUEUE).build();
    }

    @Bean
    public Binding delayBinding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(BASE_DELAY_ROUTINGKEY).noargs();
    }


    /** topic队列 */
    @Bean
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(BASE_TOPIC_EXCHANGE).durable(true).build();
    }

    @Bean
    public Queue topicQueue(){
        return QueueBuilder.durable(BASE_TOPIC_QUEUE).build();
    }

    @Bean
    public Binding topicBinding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(BASE_TOPIC_ROUTINGKEY).noargs();
    }
}
