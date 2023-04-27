package br.com.jsnsoftware.command;


import br.com.jsnsoftware.model.InventoryModel;
import br.com.jsnsoftware.model.PaymentModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Invoker {

    private Command command ;

    public void store(Command command){
        this.command = command ;
    }

    public void operation(PaymentModel payment){

        InventoryModel inventoryModel = new InventoryModel();

        inventoryModel.setOrderId(payment.getOrderId());
        inventoryModel.setStatus("PROCESSING");
        ObjectMapper mapper = new ObjectMapper();

        String json = null ;

        try {
            json = mapper.writeValueAsString(inventoryModel);
            command.execute(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
