package br.com.jsnsoftware.service;


import br.com.jsnsoftware.command.Command;
import br.com.jsnsoftware.command.ConcreteCommand;
import br.com.jsnsoftware.command.Invoker;
import br.com.jsnsoftware.command.Receiver;
import br.com.jsnsoftware.model.OrderModel;
import br.com.jsnsoftware.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OrderService {

    @Autowired
    OrderRepository orderRepository ;
    @Autowired
    private Invoker invoker ;
    @Autowired
    private Receiver receiver ;


    public OrderModel newOrder(OrderModel order){
        Date now = new Date();
        if(order != null){
            order.setStatus("PROCESSING");
            order.setDate(now.toString());
            OrderModel orderModel = orderRepository.saveAndFlush(order) ;
             Command command = new ConcreteCommand(receiver);
            invoker.storage(command);
            invoker.operation(orderModel);

            return orderModel ;
        }
        return null ;

    }

    public List<OrderModel> listOrder(){

           List<OrderModel> listOrderModel = orderRepository.findAll();

        return listOrderModel ;

    }


    @RabbitListener(queues = "ORDER_MQ")
    public void receiver(@Payload String msg){
        Date now = new Date();

        System.out.println("MESSAGE RECEIVER " + msg);
        ObjectMapper mapper = new ObjectMapper();
        try {
            OrderModel orderModel = mapper.readValue(msg , OrderModel.class);
            OrderModel order  =  orderRepository.findId(orderModel.getId());

            order.setStatus("COMPLETE");
            order.setDate(now.toString());

            orderRepository.save(order);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }





}


