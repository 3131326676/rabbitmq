package workQueue;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitmqUtil;

import java.io.IOException;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/7 2:10 下午
 */
public class Consumer1 {
    @Test
    public void consumeMessage() throws Exception {
        Connection connection = RabbitmqUtil.getConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare("work", true, false, false, null);
        // 设置一次只接受一条未确认的消息
        channel.basicQos(1);

        channel.basicConsume("work", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("消费者1接收到:" + new String(body));
                // 手动签收
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

        System.in.read();
        RabbitmqUtil.closeChannelAndConnect(channel, connection);
    }
}
