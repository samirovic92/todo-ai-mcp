package com.sei.todoservice.infrastructure.adapter;

import com.sei.todoservice.domain.model.Todo;
import com.sei.todoservice.domain.port.spi.TodoPersistencePort;
import com.sei.todoservice.infrastructure.mapper.TodoEntityMapper;
import com.sei.todoservice.infrastructure.repository.TodoJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@AllArgsConstructor
public class TodoPersistenceAdapter implements TodoPersistencePort {

    private final TodoJpaRepository todoJpaRepository;

    @Override
    public Todo save(Todo todo) {
        var todoEntity = TodoEntityMapper.INSTANCE.toEntity(todo);
        var savedTodoEntity = todoJpaRepository.save(todoEntity);
        return TodoEntityMapper.INSTANCE.toDomain(savedTodoEntity);
    }

    @Override
    public void deleteById(Long id) {
        todoJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoJpaRepository.findById(id).map(TodoEntityMapper.INSTANCE::toDomain);
    }

    @Override
    public List<Todo> findAll() {
        return todoJpaRepository.findAll().stream()
                .map(TodoEntityMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }
}
