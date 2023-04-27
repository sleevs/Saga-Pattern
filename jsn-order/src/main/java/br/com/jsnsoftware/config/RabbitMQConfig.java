package br.com.jsnsoftware.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue ;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitMQConfig {

    private static final String ROUTING_KEY = "PAYMENT_KEY";
    private static final String EXCHANGE = "TRANSACTION_EXCHANGE";
    @Value("${queue.name}")
    private String msg ;


    @Bean
    public Queue queue(){
        return  new Queue(msg , true);
    }


}
