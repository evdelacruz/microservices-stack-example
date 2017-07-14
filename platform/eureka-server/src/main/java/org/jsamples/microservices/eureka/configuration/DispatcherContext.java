package org.jsamples.microservices.eureka.configuration;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * ...
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@Configuration
public class DispatcherContext implements EmbeddedServletContainerCustomizer {
    private static final HttpStatus[] STATUS = new HttpStatus[]{HttpStatus.INTERNAL_SERVER_ERROR,
                                                                HttpStatus.NOT_FOUND,
                                                                HttpStatus.FORBIDDEN,
                                                                HttpStatus.UNAUTHORIZED};
    
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(Arrays.stream(STATUS).map(this::from).toArray(ErrorPage[]::new));
    }

    //<editor-fold desc="Support methods">
    private ErrorPage from(HttpStatus status) {
        return new ErrorPage(status, "/error/"+status.value());
    }
    //</editor-fold>
}
