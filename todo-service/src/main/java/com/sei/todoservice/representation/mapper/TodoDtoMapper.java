package com.sei.todoservice.representation.mapper;

import com.sei.todoservice.domain.model.Todo;
import com.sei.todoservice.representation.request.CreateTodoRequest;
import com.sei.todoservice.representation.response.TodoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoDtoMapper {

    TodoDtoMapper INSTANCE = Mappers.getMapper(TodoDtoMapper.class);

    Todo toDomain(CreateTodoRequest createTodoRequest);

    TodoResponse toResponse(Todo todo);
}
