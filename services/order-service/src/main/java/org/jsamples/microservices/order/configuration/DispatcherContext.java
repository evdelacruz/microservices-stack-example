package org.jsamples.microservices.order.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

@Configuration
@ComponentScan("org.jsamples.microservices.order.controllers")
public class DispatcherContext extends WebMvcConfigurerAdapter {

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
