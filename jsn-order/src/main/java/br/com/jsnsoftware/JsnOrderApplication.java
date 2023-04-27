package br.com.jsnsoftware;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "br.com.jsnsoftware"  )
public class JsnOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsnOrderApplication.class, args);
	}

}
