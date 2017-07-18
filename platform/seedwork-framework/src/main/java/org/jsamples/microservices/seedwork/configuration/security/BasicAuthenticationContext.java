package org.jsamples.microservices.seedwork.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

public class BasicAuthenticationContext extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser(username)
                .password(password)
                .authorities("ROLE_CLIENT");
    }

    //<editor-fold desc="Dependency Injection">
    private @Value("${app.security.username}") String username;
    private @Value("${app.security.password}") String password;
    //</editor-fold>
}
