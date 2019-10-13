package com.caoc.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProducer {
	public static final String EXCHANGE_NAME = "exchange_demo";
	public static final String ROUTING_KEY = "routing_key_demo";
	public static final String QUEUE_NAME = "queue_demo";
	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 5672;

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("guest");
		factory.setPassword("guest");

		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

			String mesage = "hello world";
			channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.TEXT_PLAIN, mesage.getBytes());

			channel.close();
			connection.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

}
