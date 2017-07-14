package org.jsamples.microservices.eureka.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import java.util.Collections;

/**
 * ...
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@Configuration
public class SecurityContext extends WebSecurityConfigurerAdapter {

    public SecurityContext() {
        super();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().accessDecisionManager(accessDecisionManager())
                .anyRequest().authenticated()
            .and()
                .httpBasic().realmName(name)
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .csrf().disable();
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        UnanimousBased decisionManager = new UnanimousBased(Collections.singletonList(new WebExpressionVoter()));
        decisionManager.setAllowIfAllAbstainDecisions(false);
        return decisionManager;
    }

    @Configuration
    public class SecurityAuthenticationContext extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder builder) throws Exception {
            builder.inMemoryAuthentication()
                    .withUser(username)
                    .password(password)
                    .authorities("ROLE_CLIENT")
                .and()
                    .passwordEncoder(passwordEncoder());
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance();
        }
    }

    //<editor-fold desc="Dependency Injection">
    private @Value("${spring.application.name}") String name;
    private @Value("${app.security.username}") String username;
    private @Value("${app.security.password}") String password;
    //</editor-fold>
}
