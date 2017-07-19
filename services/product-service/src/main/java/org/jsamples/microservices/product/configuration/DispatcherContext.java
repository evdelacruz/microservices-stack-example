package org.jsamples.microservices.product.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

/**
 * ...
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@Configuration
public class DispatcherContext extends WebMvcConfigurerAdapter {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(converter -> {
            if (converter instanceof AbstractJackson2HttpMessageConverter) {
                ((AbstractJackson2HttpMessageConverter) converter).getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }
        });
    }
}
