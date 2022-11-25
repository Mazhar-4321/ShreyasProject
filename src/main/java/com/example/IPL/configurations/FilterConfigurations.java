package com.example.IPL.configurations;

import com.example.IPL.filters.AuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterConfigurations {
    @Bean
    public WebMvcConfigurer some()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                .allowedMethods("*");
            }
        };
    }
    @Bean
    public AuthenticationFilter getFilter()
    {
        return new AuthenticationFilter();
    }
}
