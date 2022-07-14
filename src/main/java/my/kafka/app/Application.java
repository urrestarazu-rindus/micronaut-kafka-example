package my.kafka.app;

import io.micronaut.runtime.Micronaut;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}