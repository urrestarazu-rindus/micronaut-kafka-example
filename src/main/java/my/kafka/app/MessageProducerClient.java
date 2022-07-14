package my.kafka.app;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface MessageProducerClient {
    @Topic("my-products")
    void sendProduct(@KafkaKey String brand, String name);
}