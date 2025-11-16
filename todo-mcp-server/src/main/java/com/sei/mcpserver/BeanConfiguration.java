package com.sei.mcpserver;

import com.sei.mcpserver.domain.port.api.TodoServicePort;
import com.sei.mcpserver.domain.port.spi.TodoPersistencePort;
import com.sei.mcpserver.domain.service.TodoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TodoServicePort todoServicePort(TodoPersistencePort todoPersistencePort) {
        return new TodoServiceImpl(todoPersistencePort);
    }
}
