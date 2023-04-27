package br.com.jsnsoftware.notification.service;


import br.com.jsnsoftware.notification.command.Command;
import br.com.jsnsoftware.notification.command.ConcreteCommand;
import br.com.jsnsoftware.notification.command.Invoker;
import br.com.jsnsoftware.notification.command.Receiver;
import br.com.jsnsoftware.notification.model.NotificationModel;
import br.com.jsnsoftware.notification.repository.NotificationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository ;
    @Autowired
    private Invoker invoker ;

    @Autowired
    private Receiver receiver ;

    @RabbitListener(queues = "NOTIFICATION_MQ")
    public void receiver(@Payload String msg){

        Command command = new ConcreteCommand(receiver);
        System.out.println("MENSAGEM RECUPERADA " + msg);
        ObjectMapper mapper = new ObjectMapper();
        try {
            NotificationModel notificationModel = mapper.readValue(msg , NotificationModel.class);
            notificationModel.setStatus("PROCESSING");
            notificationRepository.saveAndFlush(notificationModel);

            invoker.store(command);
            invoker.operation(notificationModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
