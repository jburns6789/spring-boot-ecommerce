package com.luv2code.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration

public class SecurityConfiguration {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //protect endpoint /api/orders
        http.authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/api/orders/**")
                                .authenticated()
                                .anyRequest().permitAll())
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));

        // + CORS filters
        http.cors(Customizer.withDefaults());

        // + content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        // + non-empty response body for 401 (more friendly)
        Okta.configureResourceServer401ResponseBody(http);

        // we are not using Cookies for session tracking >> disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}




/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->{
            configurer.requestMatchers("/api/orders/**").authenticated().requestMatchers("/**").permitAll();;

        }).oauth2ResourceServer((oauth2) -> oauth2
                .jwt(Customizer.withDefaults()
                )
        );

        // add CORS filters
        http.cors(cors -> Customizer.withDefaults());

        // add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // force a non-empty response body for 401's to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);

        //disable CSRF since cookies aren't being used for session tracking
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    */

