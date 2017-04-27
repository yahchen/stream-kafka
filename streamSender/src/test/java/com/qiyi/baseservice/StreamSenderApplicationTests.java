package com.qiyi.baseservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamSenderApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void testSendRecive(){
		//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//		SendService sender = context.getBean(SendService.class);
//		sender.sayHello();
		//KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true, "test");
//				"--spring.cloud.stream.kafka.binder.brokers=service-cloud-dc-research-kafka-online001-bjdxt9p.qiyi.virtual:9092",
//				"--spring.cloud.stream.kafka.binder.zkNodes=mbd-push-zookeeper-online001-jylt.qiyi.virtual:2181",
//				"--spring.cloud.stream.bindings.input.group=testGroup",
//				"--spring.cloud.stream.bindings.output.producer.requiredGroups=" + randomGroup);
//		DirectChannel dataProducer = new DirectChannel();
//		BinderFactory binderFactory = context.getBean(BinderFactory.class);
//
//
//		QueueChannel dataConsumer = new QueueChannel();
//
//		((KafkaMessageChannelBinder) binderFactory.getBinder("kafka", MessageChannel.class))
//				.bindProducer("dataIn", dataProducer, new ExtendedProducerProperties<>(new KafkaProducerProperties()));
//
//		String testPayload = "testFoo" + randomGroup;
//		dataProducer.send(MessageBuilder.withPayload(testPayload).build());
//
//		Message<?> receive = dataConsumer.receive(60_000);
//		Assert.assertThat(receive.getPayload(), CoreMatchers.equalTo(testPayload));	final String randomGroup = UUID.randomUUID().toString();
//		ConfigurableApplicationContext context = SpringApplication.run(StreamSenderApplication.class,
	}
}
