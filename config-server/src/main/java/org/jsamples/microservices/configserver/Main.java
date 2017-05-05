package org.jsamples.microservices.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Clase principal de ejecui&oacute;n.
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@EnableConfigServer
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
