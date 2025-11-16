package com.sei.mcpserver.representation.controller;

import com.sei.mcpserver.domain.port.api.TodoServicePort;
import com.sei.mcpserver.representation.mapper.TodoDtoMapper;
import com.sei.mcpserver.representation.request.CreateTodoRequest;
import com.sei.mcpserver.representation.request.UpdateTodoRequest;
import com.sei.mcpserver.representation.response.TodoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController implements TodoApi {

    private final TodoServicePort todoServicePort;

    @PostMapping
    @Override
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody CreateTodoRequest createTodoRequest) {
        var todo = TodoDtoMapper.INSTANCE.toDomain(createTodoRequest);
        var savedTodo = todoServicePort.save(todo);
        return new ResponseEntity<>(TodoDtoMapper.INSTANCE.toResponse(savedTodo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        var todo = todoServicePort.findById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(TodoDtoMapper.INSTANCE.toResponse(todo));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        var todos = todoServicePort.findAll();
        var todoResponses = todos.stream()
                .map(TodoDtoMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(todoResponses);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequest updateTodoRequest) {
        var todo = todoServicePort.findById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        todo.setTitle(updateTodoRequest.getTitle());
        todo.setDescription(updateTodoRequest.getDescription());
        todo.setCompleted(updateTodoRequest.isCompleted());
        var updatedTodo = todoServicePort.update(todo);
        return ResponseEntity.ok(TodoDtoMapper.INSTANCE.toResponse(updatedTodo));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
