package com.sei.mcpserver.infrastructure.repository;

import com.sei.mcpserver.infrastructure.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
}
