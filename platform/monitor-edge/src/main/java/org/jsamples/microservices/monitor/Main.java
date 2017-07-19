package org.jsamples.microservices.monitor;

import org.jsamples.microservices.seedwork.configuration.Runner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        Runner.run(Main.class,args);
    }
}
