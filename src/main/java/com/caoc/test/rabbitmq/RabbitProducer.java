package com.caoc.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

/**
 * @author caochen
 */
public class RabbitProducer {
	public static final String EXCHANGE_NAME = "test_all_exchange_fanout_1";
	public static final String ROUTING_KEY = "routing_key_demo";
	public static final String QUEUE_NAME = "queue_demo_1";
	public static final String QUEUE_NAME_2 = "queue_demo_2";
	public static final String IP_ADDRESS = "106.15.59.97";
	public static final int PORT = 5672;

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("hello46");
		factory.setPassword("root");
		Connection connection = null;
		Channel channel = null;

		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true, false, null);
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			channel.queueDeclare(QUEUE_NAME_2, true, false, false, null);
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
			channel.queueBind(QUEUE_NAME_2, EXCHANGE_NAME, ROUTING_KEY);
			int i = 1;
			String message = "hello world";
			channel.basicPublish(EXCHANGE_NAME, "queue-1", MessageProperties.TEXT_PLAIN, message.getBytes());
			i++;
			while (i < 500) {
				message = "hello world:" + i;
				channel.basicPublish(EXCHANGE_NAME, "queue-1", MessageProperties.TEXT_PLAIN, message.getBytes());
				i++;
			}


		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
			channel.close();
			connection.close();
		}

	}

}
