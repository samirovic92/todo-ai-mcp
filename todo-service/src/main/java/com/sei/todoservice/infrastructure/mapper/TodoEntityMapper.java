package com.sei.todoservice.infrastructure.mapper;

import com.sei.todoservice.domain.model.Todo;
import com.sei.todoservice.infrastructure.entity.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoEntityMapper {

    TodoEntityMapper INSTANCE = Mappers.getMapper(TodoEntityMapper.class);

    Todo toDomain(TodoEntity todoEntity);

    TodoEntity toEntity(Todo todo);
}
