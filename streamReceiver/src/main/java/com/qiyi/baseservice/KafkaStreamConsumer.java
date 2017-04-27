package com.qiyi.baseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wangyaohui on 2017/4/21.
 */
@RestController
public class KafkaStreamConsumer {
    //display msg for html
    private Map<Integer,Message> msgCache = new TreeMap<Integer, Message>();

    @RequestMapping("/pull")
    public Message display(){
        return msgCache.get(0);
    }

    @StreamListener(Sink.INPUT)
    public void process(Message<String> message){
        //add msg handler------------------>
        {
            msgCache.put(0,message);
            System.out.println(message.getPayload().toString());
        }
        //handle msg end-------------------->
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            acknowledgment.acknowledge();
        }
    }

}
