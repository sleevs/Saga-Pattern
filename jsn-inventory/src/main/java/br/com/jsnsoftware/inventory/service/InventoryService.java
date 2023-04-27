package br.com.jsnsoftware.inventory.service;

import br.com.jsnsoftware.inventory.command.Command;
import br.com.jsnsoftware.inventory.command.ConcreteCommand;
import br.com.jsnsoftware.inventory.command.Invoker;
import br.com.jsnsoftware.inventory.command.Receiver;
import br.com.jsnsoftware.inventory.model.InventoryModel;
import br.com.jsnsoftware.inventory.repository.InventoryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InventoryService {



    @Autowired
    private InventoryRepository inventoryRepository ;

    @Autowired
    private Invoker invoker ;

    @Autowired
    private Receiver receiver ;

    @RabbitListener(queues = "INVENTORY_MQ")
    public void receiver(@Payload String msg){

        Command command = new ConcreteCommand(receiver);
        System.out.println("MENSAGEM RECUPERADA " + msg);
        ObjectMapper mapper = new ObjectMapper();
        try {
            InventoryModel inventory = mapper.readValue(msg , InventoryModel.class);
            inventory.setStatus("PROCESSING");
            inventoryRepository.saveAndFlush(inventory);

            invoker.store(command);
            invoker.operation(inventory);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



    public Integer validation(){

        return 0 ;
    }
}
