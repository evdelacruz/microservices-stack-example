package org.jsamples.microservices.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages="org.jsamples.microservices.product")
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
                }
            });
        }
    }
}
