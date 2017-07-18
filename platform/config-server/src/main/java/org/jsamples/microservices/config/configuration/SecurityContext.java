package org.jsamples.microservices.config.configuration;

import org.jsamples.microservices.seedwork.configuration.security.BasicAuthenticationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import java.util.Collections;

@Configuration
@Import(BasicAuthenticationContext.class)
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

    //<editor-fold desc="Dependency Injection">
    private @Value("${spring.application.name}") String name;
    //</editor-fold>
}
