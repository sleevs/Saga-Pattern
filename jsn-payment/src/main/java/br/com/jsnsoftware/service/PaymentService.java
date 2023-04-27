package br.com.jsnsoftware.service;

import br.com.jsnsoftware.command.Command;
import br.com.jsnsoftware.command.ConcreteCommand;
import br.com.jsnsoftware.command.Invoker;
import br.com.jsnsoftware.command.Receiver;
import br.com.jsnsoftware.model.PaymentModel;
import br.com.jsnsoftware.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository ;

    @Autowired
    private Invoker invoker ;

    @Autowired
    private Receiver receiver ;

    @RabbitListener(queues = "PAYMENT_MQ")
    public void receiver(@Payload String msg){
        Date now = new Date();
        Command command = new ConcreteCommand(receiver);
        System.out.println("MENSAGEM RECUPERADA " + msg);
        ObjectMapper mapper = new ObjectMapper();
        try {
            PaymentModel payment = mapper.readValue(msg , PaymentModel.class);
                payment.setStatus("PROCESSING");
                payment.setDate(now.toString());
            paymentRepository.saveAndFlush(payment);
            invoker.store(command);
            invoker.operation(payment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



    public Integer paymentValidation(){

        return 0 ;
    }

}
