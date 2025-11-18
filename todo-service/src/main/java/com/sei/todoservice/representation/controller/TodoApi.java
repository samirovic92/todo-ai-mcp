package com.sei.todoservice.representation.controller;

import com.sei.todoservice.representation.request.CreateTodoRequest;
import com.sei.todoservice.representation.request.UpdateTodoRequest;
import com.sei.todoservice.representation.response.TodoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Todo API", description = "API for managing todos")
public interface TodoApi {

    @Operation(summary = "Create a new todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Todo created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    ResponseEntity<TodoResponse> createTodo(@Valid CreateTodoRequest createTodoRequest);

    @Operation(summary = "Get a todo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo found"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    ResponseEntity<TodoResponse> getTodoById(Long id);

    @Operation(summary = "Get all todos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos found")
    })
    ResponseEntity<List<TodoResponse>> getAllTodos();

    @Operation(summary = "Update a todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo updated successfully"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    ResponseEntity<TodoResponse> updateTodo(Long id, UpdateTodoRequest updateTodoRequest);

    @Operation(summary = "Delete a todo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Todo deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    ResponseEntity<Void> deleteTodoById(Long id);
}
