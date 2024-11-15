package com.example.system.control.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) для передачи данных задач.
 * Содержит поля для title, description, а также валидацию для каждого поля.
 */
@Getter
@Setter
public class TaskDto {

    /**
     * Уникальный идентификатор задачи.
     */
    private Integer id;

    /**
     * Заголовок задачи.
     */
    private String title;

    /**
     * Описание задачи.
     */
    private String description;

    /**
     * Статус задачи (например, "в ожидании", "в процессе", "завершено").
     */
    private String status;

    /**
     * Приоритет задачи (например, "Низкий", "Средний", "Высокий").
     */
    private String priority;
}
