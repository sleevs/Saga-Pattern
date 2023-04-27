package br.com.jsnsoftware.inventory.command;

import br.com.jsnsoftware.inventory.model.InventoryModel;
import br.com.jsnsoftware.inventory.model.ShippingModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Invoker {

    private Command command ;
    public void store(Command command){
      this.command = command ;
    }

    public void operation(InventoryModel inventory){
        ShippingModel shippingModel = new ShippingModel();

        shippingModel.setType("DELIVERY");
        shippingModel.setDesc(inventory.getDesc());
        shippingModel.setProduct(shippingModel.getProduct());
        shippingModel.setOrderId(inventory.getOrderId());
        shippingModel.setStatus("PROCESSING");
        ObjectMapper mapper = new ObjectMapper();

        String json = null ;

        try {
            json = mapper.writeValueAsString(shippingModel);
            command.execute(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
