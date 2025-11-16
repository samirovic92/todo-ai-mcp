package com.sei.mcpserver.representation.mapper;

import com.sei.mcpserver.domain.model.Todo;
import com.sei.mcpserver.representation.request.CreateTodoRequest;
import com.sei.mcpserver.representation.response.TodoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoDtoMapper {

    TodoDtoMapper INSTANCE = Mappers.getMapper(TodoDtoMapper.class);

    Todo toDomain(CreateTodoRequest createTodoRequest);

    TodoResponse toResponse(Todo todo);
}
