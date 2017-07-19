package org.jsamples.microservices.product;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages="org.jsamples.microservices.product")
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class, args);
    }
}
