package com.wanuq.flowabledemo;

import org.flowable.rest.security.BasicAuthenticationProvider;
import org.flowable.rest.security.SecurityConstants;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public AuthenticationProvider authenticationProvider() {
        BasicAuthenticationProvider basicAuthenticationProvider = new BasicAuthenticationProvider();
        basicAuthenticationProvider.setVerifyRestApiPrivilege(true);
        return basicAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity = http.authenticationProvider(authenticationProvider()).sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

        httpSecurity.authorizeRequests().requestMatchers(EndpointRequest.to(InfoEndpoint.class, HealthEndpoint.class))
                .authenticated().requestMatchers(EndpointRequest.toAnyEndpoint())
                .hasAnyAuthority(SecurityConstants.ACCESS_ADMIN);

        httpSecurity.authorizeRequests().anyRequest().hasAuthority(SecurityConstants.PRIVILEGE_ACCESS_REST_API).and()
                .httpBasic();
    }

}
