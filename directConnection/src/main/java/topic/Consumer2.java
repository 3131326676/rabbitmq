package topic;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitmqUtil;

import java.io.IOException;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/7 4:50 下午
 */
public class Consumer2 {

    @Test
    public void consumeMessage() throws Exception {
        Connection connection = RabbitmqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topic", BuiltinExchangeType.TOPIC);
        // 从通道中获取一个临时队列
        String queue = channel.queueDeclare().getQueue();
        // 把临时队列和交换机绑定
        channel.queueBind(queue, "topic", "user.#");

        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("消费者2接收到的消息:" + new String(body));
            }
        });

        System.in.read();
    }
}
