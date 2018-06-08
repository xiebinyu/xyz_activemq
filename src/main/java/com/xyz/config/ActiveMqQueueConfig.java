package com.xyz.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class ActiveMqQueueConfig {

  @Bean
  public Queue queue() {
    return new ActiveMQQueue("queue");
  }

  /**
   * 自定义队列
   */
  public static Queue getQueue(String name){
    return new ActiveMQQueue(name);
  }
}
