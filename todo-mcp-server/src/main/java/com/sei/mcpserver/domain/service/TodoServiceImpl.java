package com.sei.mcpserver.domain.service;

import com.sei.mcpserver.domain.model.Todo;
import com.sei.mcpserver.domain.port.api.TodoServicePort;
import com.sei.mcpserver.domain.port.spi.TodoPersistencePort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TodoServiceImpl implements TodoServicePort {

    private final TodoPersistencePort todoPersistencePort;

    @Override
    public Todo save(Todo todo) {
        return todoPersistencePort.save(todo);
    }

    @Override
    public void deleteById(Long id) {
        todoPersistencePort.deleteById(id);
    }

    @Override
    public Todo findById(Long id) {
        return todoPersistencePort.findById(id).orElse(null);
    }

    @Override
    public List<Todo> findAll() {
        return todoPersistencePort.findAll();
    }

    @Override
    public Todo update(Todo todo) {
        return todoPersistencePort.save(todo);
    }
}
