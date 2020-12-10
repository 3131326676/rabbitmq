package workQueue;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitmqUtil;

import java.io.IOException;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/7 2:18 下午
 */
public class Consumer2 {
    @Test
    public void consumeMessage() throws Exception {
        Connection connection = RabbitmqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("work", true, false, false, null);

        channel.basicConsume("work", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("消费者2接收到:" + new String(body));
            }
        });

        System.in.read();
        RabbitmqUtil.closeChannelAndConnect(channel, connection);
    }
}
