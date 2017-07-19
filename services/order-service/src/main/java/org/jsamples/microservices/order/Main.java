package org.jsamples.microservices.order;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages="org.jsamples.microservices.order.configuration")
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class, args);
    }
}
