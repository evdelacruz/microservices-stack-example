package org.jsamples.microservices.eureka;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main class.
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class, args);
    }
}
