package my.kafka.app;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(groupId = "productsGroup")
public class MessageListener {

    private static final Logger logger  = LoggerFactory.getLogger(MessageListener.class);

    @Topic("my-products")
    public void receive(@KafkaKey String brand, String name) {
        logger.info("Got Product - " + name + " by " + brand);
    }
}