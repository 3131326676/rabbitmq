package routingKey;

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
        channel.exchangeDeclare("test", BuiltinExchangeType.DIRECT);
        // 发送四条消息分别指定不同的routingKey
        channel.basicPublish("test", "info", null, "直连+info".getBytes());
        channel.basicPublish("test", "error", null, "直连+error".getBytes());
        channel.basicPublish("test", "debug", null, "直连+debug".getBytes());
        channel.basicPublish("test", "warn", null, "直连+warn".getBytes());


        RabbitmqUtil.closeChannelAndConnect(channel, connection);
        System.out.println("发送完成");
    }
}
