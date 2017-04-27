package com.qiyi.baseservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import java.util.UUID;

@SpringBootApplication
@EnableBinding(Source.class)
public class StreamSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSenderApplication.class, args);
    }
}
