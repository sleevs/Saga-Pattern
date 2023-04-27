package br.com.jsnsoftware.notification.command;


import br.com.jsnsoftware.notification.model.NotificationModel;
import br.com.jsnsoftware.notification.model.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Invoker {

    Command command ;

   public void store(Command command){
       this.command = command ;
   }

   public void operation(NotificationModel notification){

      OrderModel orderModel = new OrderModel();
      orderModel.setId(notification.getOrderId());

      String json = null ;
      ObjectMapper mapper = new ObjectMapper();

      try {
         json = mapper.writeValueAsString(orderModel);
         command.execute(json);
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      }


   }
}
