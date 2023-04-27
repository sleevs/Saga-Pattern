package br.com.jsnsoftware.command;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
public class Receiver {

    @Autowired
    private RabbitTemplate rabbitTemplate ;
    @Autowired
    private AmqpTemplate amqpTemplate ;
    @Autowired
    Queue queue ;


    public void action (String msg){

            rabbitTemplate.convertAndSend(this.queue.getName(),msg);

    }
}
