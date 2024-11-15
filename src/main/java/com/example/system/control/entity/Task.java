package com.example.system.control.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Класс, представляющий задачу.
 * Содержит информацию о заголовке, описании, статусе и приоритете задачи.
 * Данный класс используется в приложении для управления задачами.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

    /**
     * Уникальный идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Заголовок задачи.
     */
    @Schema(description = "Заголовок")
    @Column(name = "title")
    private String title;

    /**
     * Описание задачи.
     */
    @Schema(description = "Описание")
    @Column(name = "description")
    private String description;

    /**
     * Статус задачи (например, "в ожидании", "в процессе", "завершено").
     */
    @Schema(description = "Статус")
    @Column(name = "status")
    private String status;

    /**
     * Приоритет задачи (например, "Низкий", "Средний", "Высокий").
     */
    @Schema(description = "Приоритет")
    @Column(name = "priority")
    private String priority;
}
