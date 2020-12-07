package workQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import utils.RabbitmUtil;

/**
 * @author qumingbo
 * @version 1.0
 * @date 2020/12/7 2:06 下午
 */
public class Producer {

    @Test
    public void sendMessage() throws Exception {
        Connection connection = RabbitmUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("work",true,false,false,null);

        for (int i = 0; i < 10; i++) {
            channel.basicPublish("","work",null, String.valueOf(i).getBytes());
        }

        RabbitmUtil.closeChannelAndConnect(channel,connection);
        System.out.println("消息发送成功");
    }
}
