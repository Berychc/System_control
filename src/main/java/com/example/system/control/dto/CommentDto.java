package com.example.system.control.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) для передачи данных комментария.
 * Используется для создания и обновления комментариев в приложении.
 */
@Getter
@Setter
public class CommentDto {

    /**
     * Текст комментария.
     */
    private String text;
}
