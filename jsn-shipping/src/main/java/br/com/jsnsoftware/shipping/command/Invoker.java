package br.com.jsnsoftware.shipping.command;


import br.com.jsnsoftware.shipping.model.NotificationModel;
import br.com.jsnsoftware.shipping.model.ShippingModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Invoker {

    private Command command ;

    public void store(Command command){
        this.command = command ;
    }


    public void operation(ShippingModel shipping){


        NotificationModel notificationModel = new NotificationModel();

        notificationModel.setOrderId(shipping.getOrderId());
        notificationModel.setType("FULL");
        notificationModel.setDesc(shipping.getDesc());
        notificationModel.setStatus("PROCESSING");
        ObjectMapper mapper = new ObjectMapper();

        String json = null ;

        try {
            json = mapper.writeValueAsString(notificationModel);
            command.execute(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
