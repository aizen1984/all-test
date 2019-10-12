package com.ethan.test.rabbitmq.practice;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqPractice {

	public static final String EXCHANGE_NAME = "exchange_demo";
	public static final String ROUTING_KEY = "routing_key_demo";
	public static final String QUEUE_NAME = "queue_demo";
	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 5672;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setPort(PORT);
		connectionFactory.setHost(IP_ADDRESS);

		try {
			Connection connection = connectionFactory.newConnection();
			Channel channel = connection.createChannel();

			channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
