package com.xyz.client;

import com.xyz.config.ActiveMqQueueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/api")
public class ActiveMqClient {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Autowired
  private Queue queue;

  @RequestMapping("/send")
  public void send(@RequestParam(value="name") String name){
    System.out.println("发送数据：I am " + name);
    // 发送队列
    jmsTemplate.convertAndSend(ActiveMqQueueConfig.getQueue("queue"), name);
    jmsTemplate.convertAndSend(this.queue, name);
  }
}
