package com.caoc.test.rabbitmq.practice;

import com.caoc.test.rabbitmq.RabbitMqConfig;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class ProductPractice {


	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 5672;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setPort(PORT);
		connectionFactory.setHost(IP_ADDRESS);
		Connection connection;
		Channel channel;
		try {
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();


			// 交换器对交换器
			/*channel.exchangeDeclare("source", "direct", true, false, null);
			channel.exchangeDeclare("destination", "fanout", false, true, null);
			channel.exchangeBind("destination", "source", "exKey");
			channel.queueDeclare("queue", false, false, true, null);
			channel.queueBind("queue", "destination", "");
			channel.basicPublish("source","exKey",null,"extDemo".getBytes());*/

			//发送消息到队列
			channel.exchangeDeclare(RabbitMqConfig.EXCHANGE1, "direct", true, false, null);
			channel.queueDeclare(RabbitMqConfig.QUEUE1, false, false, false, null);
			channel.queueBind(RabbitMqConfig.QUEUE1, RabbitMqConfig.EXCHANGE1, RabbitMqConfig.ROUTING_KEY1);
			//普通发送
			/*channel.basicPublish(RabbitMqConfig.EXCHANGE1, RabbitMqConfig.ROUTING_KEY1, true,
					new AMQP.BasicProperties().builder().deliveryMode(2).priority(1).userId("guest").build()
					, "normal-hello".getBytes());*/
			//带有headers信息
			IntStream.range(1,10).forEach(i->{
				Map<String, Object> headers = new HashMap<>();
				headers.put("location", "here");
				headers.put("day", "now");
				try {
					channel.basicPublish(RabbitMqConfig.EXCHANGE1, RabbitMqConfig.ROUTING_KEY1,
							new AMQP.BasicProperties().builder().deliveryMode(2).headers(headers)
									//.expiration("6000")
									.build(), "withHeaders".getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});*/

			//ttl exchange
			channel.exchangeDeclare("ttlExchange", "direct", true, false, null);
			//for queue ttl
			Map<String, Object> queueArgs = new HashMap<>();
			queueArgs.put("x-message-ttl", 60000);
			channel.queueDeclare("ttlQueue", true, false, false, queueArgs);
			channel.queueBind("ttlQueue", "ttlExchange", "tllRoutingKey");
			// for message ttl
			AMQP.BasicProperties.Builder builder2 = new AMQP.BasicProperties.Builder();
			builder2.expiration("60000");//60000ms
			AMQP.BasicProperties properties = builder2.build();
			channel.basicPublish("ttlExchange", "tllRoutingKey", true, properties, "ttl".getBytes());


			System.out.println("发送");*/

			//没有投递到队列
			channel.basicPublish(EXCHANGE1, ROUTING_KEY1, true,
					MessageProperties.PERSISTENT_TEXT_PLAIN, "hello".getBytes());
			channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> {
				String message = new String(body);
				System.out.println("Basic.Return返回的结果是" + message);
			});

			//备用
			Map<String, Object> map = new HashMap<>();
			map.put("alternate-exchange", "myAe");
			channel.exchangeDeclare("normalExchange", "direct", true, false, map);
			channel.exchangeDeclare("myAe", "fanout", true, false, null);
			channel.queueDeclare("normalQueue", true, false, false, null);
			channel.queueBind("normalQueue", "normalExchange", "normalKey");
			Map<String, Object> queueMap = new HashMap<>();
			queueMap.put("x-message-ttl", 6000);
			channel.queueDeclare("unnormalQueue", true, false, false, null);
			channel.queueBind("unnormalQueue", "myAe", "");

			AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
			builder.deliveryMode(2);
			builder.expiration("60000");
			AMQP.BasicProperties properties = builder.build();
			channel.basicPublish(EXCHANGE1, ROUTING_KEY1, properties, "hello46".getBytes());


			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
