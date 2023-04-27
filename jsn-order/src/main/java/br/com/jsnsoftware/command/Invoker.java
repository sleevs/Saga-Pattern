package br.com.jsnsoftware.command;

import br.com.jsnsoftware.model.OrderModel;
import br.com.jsnsoftware.model.PaymentModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Invoker {

    private Command command ;

    public void storage(Command command){
        this.command = command ;
    }

    public void operation(OrderModel orderModel){

        PaymentModel payment = new PaymentModel();
        payment.setProduct(orderModel.getProductCode());
        payment.setOrderId(orderModel.getId());


        ObjectMapper mapper = new ObjectMapper();
        String paymentJson = null;
        try {
            paymentJson = mapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        command.execute(paymentJson);
    }


}
