package com.sei.todoservice.domain.port.api;

import com.sei.todoservice.domain.model.Todo;

import java.util.List;

public interface TodoServicePort {
    Todo save(Todo todo);
    void deleteById(Long id);
    Todo findById(Long id);
    List<Todo> findAll();
    Todo update(Todo todo);
}
