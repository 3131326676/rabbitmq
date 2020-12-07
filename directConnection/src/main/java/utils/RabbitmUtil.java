package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version 1.0
 */
public class RabbitmUtil {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        // Host地址
        connectionFactory.setHost("39.96.54.49");
        // 端口号
        connectionFactory.setPort(5672);
        // 账户名
        connectionFactory.setUsername("qmb");
        // 密码
        connectionFactory.setPassword("smd521314");
        // 虚拟机
        connectionFactory.setVirtualHost("/learn");
    }

    public static Connection getConnection() {
        // 从工厂创建一个连接
        try {
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeChannelAndConnect(Channel channel, Connection connection) {
        try {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
