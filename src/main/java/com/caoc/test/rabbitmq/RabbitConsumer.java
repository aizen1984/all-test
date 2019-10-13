package com.caoc.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
	public static final String EXCHANGE_NAME = "exchange_demo";
	public static final String ROUTING_KEY = "routing_key_demo";
	public static final String QUEUE_NAME = "queue_demo";
	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 5672;

	public static void main(String[] args) {
		Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("guest");
		factory.setPassword("guest");

		try {
			final Connection connection = factory.newConnection(addresses);
			final Channel channel = connection.createChannel();
			channel.basicQos(64);

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
						throws IOException {
					System.out.println("recv message-->" + new String(body));
					try {
						TimeUnit.SECONDS.sleep(1);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					channel.basicAck(envelope.getDeliveryTag(), false);
//					super.handleDelivery(consumerTag, envelope, properties, body);
				}
			};
			channel.basicConsume(QUEUE_NAME, consumer);
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

}
