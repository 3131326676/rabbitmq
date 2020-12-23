package com.example.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/23 6:07 下午
 */
@Configuration
public class WorkConfig {

    @Bean
    public Queue work() {
        return new Queue("work");
    }
}
