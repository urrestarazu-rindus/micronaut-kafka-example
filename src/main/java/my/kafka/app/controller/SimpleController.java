package my.kafka.app.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import my.kafka.app.MessageListener;
import my.kafka.app.MessageProducerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/product/send")
public class SimpleController {
    @Inject
    ApplicationContext applicationContext;

    MessageListener messageListener = new MessageListener();

    private static final Logger logger  = LoggerFactory.getLogger(SimpleController.class);

    @Get()
    public HttpResponse<?> sendProduct() {
        logger.info("Get Send product");

        MessageProducerClient client = applicationContext.getBean(MessageProducerClient.class);
        String brand = "Nike";
        client.sendProduct(brand, "Blue Trainers");

        return HttpResponse.status(HttpStatus.OK).body("Sent " + brand);
    }
}

