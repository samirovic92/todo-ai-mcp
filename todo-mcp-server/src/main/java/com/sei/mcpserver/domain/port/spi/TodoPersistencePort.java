package com.sei.mcpserver.domain.port.spi;

import com.sei.mcpserver.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoPersistencePort {
    Todo save(Todo todo);
    void deleteById(Long id);
    Optional<Todo> findById(Long id);
    List<Todo> findAll();
}
