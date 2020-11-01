package org.example;

import org.example.TicketPrices.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.ConfigurableApplicationContext;

@Configuration
@EnableConfigurationProperties(Config.class)
@SpringBootApplication
public class DemoApplication {
public static void main(String[] args)
{
//ConfigurableApplicationContext context =
      //  SpringApplication.run(DemoApplication.class,args);
  //  ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
  //  TicketPriceServiceImpl ticketPriceService  = context.getBean(TicketPriceServiceImpl.class);
 //String resultstr =   ticketPriceService.getTicketPrices("{}");
    SpringApplication application = new SpringApplication(DemoApplication.class);
    application.run(args);
}

}
