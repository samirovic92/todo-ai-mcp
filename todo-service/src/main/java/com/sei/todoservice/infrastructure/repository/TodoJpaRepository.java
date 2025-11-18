package com.sei.todoservice.infrastructure.repository;

import com.sei.todoservice.infrastructure.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
}
