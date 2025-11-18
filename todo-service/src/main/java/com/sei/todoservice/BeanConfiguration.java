package com.sei.todoservice;

import com.sei.todoservice.domain.port.api.TodoServicePort;
import com.sei.todoservice.domain.port.spi.TodoPersistencePort;
import com.sei.todoservice.domain.service.TodoServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public TodoServicePort todoServicePort(TodoPersistencePort todoPersistencePort) {
        return new TodoServiceImpl(todoPersistencePort);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
