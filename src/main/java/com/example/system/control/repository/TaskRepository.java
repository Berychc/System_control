package com.example.system.control.repository;

import com.example.system.control.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с задачами.
 * Предоставляет методы для поиска изображений в базе данных.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
