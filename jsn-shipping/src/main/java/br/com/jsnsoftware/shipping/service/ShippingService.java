package br.com.jsnsoftware.shipping.service;


import br.com.jsnsoftware.shipping.command.Command;
import br.com.jsnsoftware.shipping.command.ConcreteCommand;
import br.com.jsnsoftware.shipping.command.Invoker;
import br.com.jsnsoftware.shipping.command.Receiver;
import br.com.jsnsoftware.shipping.model.ShippingModel;
import br.com.jsnsoftware.shipping.repository.ShippingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {



    @Autowired
    private ShippingRepository shippingRepository ;
    @Autowired
    private Invoker invoker ;

    @Autowired
    private Receiver receiver ;

    @RabbitListener(queues = "SHIPPING_MQ")
    public void receiver(@Payload String msg){

        Command command = new ConcreteCommand(receiver);
        System.out.println("MENSAGEM RECUPERADA " + msg);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ShippingModel shippingModel = mapper.readValue(msg , ShippingModel.class);
            shippingModel.setStatus("PROCESSING");
            shippingRepository.saveAndFlush(shippingModel);

            invoker.store(command);
            invoker.operation(shippingModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
