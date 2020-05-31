package com.caoc.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ShuHeConsumer {
	public static final String EXCHANGE_NAME = "lendengine.exchange.confirmTraceLog";
	public static final String ROUTING_KEY = null;
	public static final String QUEUE_NAME = "lendengine.queue.confirmTraceLog";
	public static final String IP_ADDRESS = "rabbitmq01.ali-bj-sit01.shuheo.net";
	public static final int PORT = 5672;

	public static void main(String[] args) {
		Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("admin");
		factory.setPassword("admin@Rabbitmq");

		try {
			final Connection connection = factory.newConnection(addresses);
			final Channel channel = connection.createChannel();
			channel.basicQos(64);

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope,
				                           AMQP.BasicProperties properties, byte[] body)
						throws IOException {
					System.out.println("recv message-->" + new String(body));
					channel.basicAck(envelope.getDeliveryTag(), false);

//					super.handleDelivery(consumerTag, envelope, properties, body);
				}
			};
			channel.basicConsume(QUEUE_NAME, consumer);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}
}
