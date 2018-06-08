package com.xyz.server;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqServer {

  /**
   * 监听队列
   */
  @JmsListener(destination = "queue")
  public void receiveQueue(String message) {
    System.out.println("接收数据：hello, " + message);
  }
}