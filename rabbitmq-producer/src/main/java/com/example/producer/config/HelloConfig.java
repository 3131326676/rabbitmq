package com.example.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/23 5:44 下午
 */
@Configuration
public class HelloConfig {

    /**
     * 创建一个队列
     */
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
}
