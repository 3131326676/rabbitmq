package com.example.customer.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/23 6:08 下午
 */
@Component
public class WorkConsumer {
    @RabbitListener(queuesToDeclare = {@Queue("work")})
    public void testWork1(String msg) {
        System.out.println("1接收到消息" + msg);
    }

    @RabbitListener(queuesToDeclare = {@Queue("work")})
    public void testWork2(String msg) {
        System.out.println("2接收到消息" + msg);
    }
}
