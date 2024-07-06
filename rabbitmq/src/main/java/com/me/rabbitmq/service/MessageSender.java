package com.me.rabbitmq.service;

import lombok.Setter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Setter
@Service
public class MessageSender {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message){
        amqpTemplate.convertAndSend(queueName, message);
    }

}
