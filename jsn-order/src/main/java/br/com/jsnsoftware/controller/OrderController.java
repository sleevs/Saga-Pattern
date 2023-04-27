package br.com.jsnsoftware.controller;


import br.com.jsnsoftware.model.OrderModel;
import br.com.jsnsoftware.repository.OrderRepository;
import br.com.jsnsoftware.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_api")
public class OrderController {



    @Autowired
    private OrderService orderService ;


    @GetMapping(value ="/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OrderModel>> getOrder(){

        List<OrderModel> result = (List<OrderModel>) orderService.listOrder();

        return ResponseEntity.ok(result) ;
    }


    @PostMapping(value ="/create")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderModel> create(@RequestBody OrderModel order){

        OrderModel result = orderService.newOrder(order);
        return ResponseEntity.ok(result) ;
    }
}
