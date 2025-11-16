package com.sei.mcpserver.infrastructure.mapper;

import com.sei.mcpserver.domain.model.Todo;
import com.sei.mcpserver.infrastructure.entity.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoEntityMapper {

    TodoEntityMapper INSTANCE = Mappers.getMapper(TodoEntityMapper.class);

    Todo toDomain(TodoEntity todoEntity);

    TodoEntity toEntity(Todo todo);
}
