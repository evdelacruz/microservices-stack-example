package org.jsamples.microservices.edge;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class, args);
    }
}
