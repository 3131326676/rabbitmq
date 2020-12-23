package com.example.customer.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/23 5:53 下午
 */
@Component
public class HelloConsumer {
    // @RabbitHandler
    @RabbitListener(queuesToDeclare = {@Queue("hello")})
    public void receive(String msg) {
        System.out.println(msg);
    }
}
