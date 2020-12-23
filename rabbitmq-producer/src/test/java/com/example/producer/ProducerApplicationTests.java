package com.example.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    /**
     * 第一种模式
     */
    @Test
    void testHello() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    /**
     * 第二种模式
     */
    @Test
    void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello world work");
        }
    }
}

