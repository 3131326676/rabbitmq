package topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import utils.RabbitmqUtil;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/7 4:30 下午
 */
public class Producer {
    @Test
    public void sendMessage() throws Exception {
        Connection connection = RabbitmqUtil.getConnection();

        Channel channel = connection.createChannel();

        // 设置交换机
        channel.exchangeDeclare("topic", BuiltinExchangeType.TOPIC);
        // 发送四条消息分别指定不同的routingKey
        channel.basicPublish("topic", "user.insert", null, "topic:insert:*".getBytes());
        channel.basicPublish("topic", "user.insert.one", null, "topic:insert:#".getBytes());
        channel.basicPublish("topic", "user.update.one", null, "topic:update:#".getBytes());
        channel.basicPublish("topic", "user", null, "topic".getBytes());


        RabbitmqUtil.closeChannelAndConnect(channel, connection);
        System.out.println("发送完成");
    }
}
