package br.com.jsnsoftware.inventory.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitMQConfig {


    @Value("${queue.name}")
    private String msg ;


    @Bean
    public Queue queue(){
        return  new Queue(msg , true);
    }

}