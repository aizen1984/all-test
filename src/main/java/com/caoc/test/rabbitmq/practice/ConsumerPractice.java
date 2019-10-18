package com.caoc.test.rabbitmq.practice;

import com.caoc.test.rabbitmq.RabbitMqConfig;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConsumerPractice {

	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 5672;

	public static void main(String[] args) {
		Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("guest");
		factory.setPassword("guest");

		//默认消费
		//先触发 handleConsumerOk 方法，之后触发 handleDelivery
		//方法，最后才触发 handleCancelOk 方法。
		try {
			final Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.basicQos(6);

			//推模式
			/*channel.basicConsume(RabbitMqConfig.QUEUE1, false, "consumerTag",
					new DefaultConsumer(channel) {
						@Override
						public void handleDelivery(String consumerTag, Envelope envelope,
						                           AMQP.BasicProperties properties,
						                           byte[] body) throws IOException {
							String routingKey = envelope.getRoutingKey();
							String contentType = properties.getContentType();
							long deliverTag = envelope.getDeliveryTag();
							System.out.println("routingKey->" + routingKey);
							System.out.println("contentType->" + contentType);
							System.out.println("deliverTag->" + deliverTag);
							System.out.println("body->" + new String(body));
							channel.basicAck(deliverTag, false);
						}
					});*/


			//拉模式
			while (true) {
				GetResponse response = channel.basicGet(RabbitMqConfig.QUEUE1, false);
				if (response == null) {
					TimeUnit.SECONDS.sleep(1);

				}
				if (response != null) {
					System.out.println(new String(response.getBody()));
					channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
