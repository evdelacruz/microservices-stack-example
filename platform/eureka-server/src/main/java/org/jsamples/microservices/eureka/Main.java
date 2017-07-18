package org.jsamples.microservices.eureka;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class, args);
    }
}
