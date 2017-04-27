package com.qiyi.baseservice;

//import com.qiyi.baseservice.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.MutableMessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyaohui on 2017/4/21.
 */
@RestController
public class ProducerController {

    @Autowired
    private Source source;

    @RequestMapping(value = "/push/{msg}", method = RequestMethod.GET)
    public String send(@PathVariable("msg") String msg){
        source.output().send(MutableMessageBuilder.withPayload(msg).build());
        return "success";
    }

}