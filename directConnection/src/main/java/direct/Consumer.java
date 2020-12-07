package direct;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitmUtil;

import java.io.IOException;

/**
 * @version 1.0
 */
public class Consumer {
    @Test
    public void sendMessage() throws Exception {
        Connection connection = RabbitmUtil.getConnection();

        // 创建一个信道
        Channel channel = connection.createChannel();
        // 绑定队列
        /**
         * 参数一 队列名  如果不存在创建一个新队列
         * 参数二 是否持久化 如果为false 重启MQ消息会丢失
         * 参数三 是否独享 true 代表只有当前的connection可以访问到该队列
         * 参数四 是否自动删除  队列不使用时会自动进行删除
         * 参数五 队列的其他参数设置
         */
        channel.queueDeclare("hello", true, false, false, null);

        /** 消费消息
         * 参数一 交换机
         * 参数二 路由key
         * 参数三 相关属性
         * 参数四 消息体
         */
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            /**
             * 参数说明
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body 消息体
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("接收到消息："+new String(body));
            }
        });

        System.in.read();
    }
}
