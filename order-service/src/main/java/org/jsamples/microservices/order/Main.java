package org.jsamples.microservices.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages="org.jsamples.microservices.order")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Configuration
    public class DispatcherConfig extends WebMvcConfigurerAdapter {

        @Override
        public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
            converters.forEach(converter -> {
                if (converter instanceof AbstractJackson2HttpMessageConverter) {
                    ((AbstractJackson2HttpMessageConverter) converter).getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    ((AbstractJackson2HttpMessageConverter) converter).getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                }
            });
        }
    }

    @Configuration
    public class DataSourceConfig  {

        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}
