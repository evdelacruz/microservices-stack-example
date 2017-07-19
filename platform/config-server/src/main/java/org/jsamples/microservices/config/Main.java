package org.jsamples.microservices.config;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Main class.
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@EnableConfigServer
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class, args);
    }
}
