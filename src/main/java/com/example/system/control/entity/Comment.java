package com.example.system.control.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность комментария.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment {

    /**
     * Уникальный идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Текст комментария.
     */
    @Schema(description = "Комментарий")
    @Column(name = "text", nullable = false)
    private String text;

    /**
     * Дата и время создания комментария.
     */
    @Schema(description = "Дата и время создания комментария")
    @Column(name = "date_time", nullable = false)
    @CreatedDate
    private LocalDateTime localDateTime;

    /**
     * Задача, к которой относится комментарий.
     */
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    /**
     * Пользователь, оставивший комментарий.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
