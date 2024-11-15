package com.example.system.control.repository;

import com.example.system.control.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с комментариями.
 * Предоставляет методы для поиска изображений в базе данных.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
