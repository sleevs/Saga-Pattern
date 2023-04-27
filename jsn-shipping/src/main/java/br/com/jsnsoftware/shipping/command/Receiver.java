package br.com.jsnsoftware.shipping.command;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Autowired
    Queue queue ;


    public void action (String msg){

        rabbitTemplate.convertAndSend(this.queue.getName(),msg);

    }
}
