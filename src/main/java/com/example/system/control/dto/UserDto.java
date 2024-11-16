package com.example.system.control.dto;

import com.example.system.control.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * DTO (Data Transfer Object) для передачи данных пользователя.
 * Содержит поля для email, пароля и роли пользователя,
 * а также валидацию для каждого поля.
 */
@Getter
@Setter
public class UserDto {

    /**
     * Адрес электронной почты пользователя.
     * Должен быть корректного формата и не может быть пустым.
     */
    @Email(message = "Некорректный формат email!")
    @NotBlank(message = "Email не может быть пустым!")
    private String email;

    /**
     * Пароль пользователя.
     * Не может быть пустым.
     */
    @NotBlank(message = "Password  не может быть пустым!")
    private String password;

    /**
     * Роль пользователя.
     * Не может быть пустой.
     */
    @NotBlank(message = "Role не может быть пуста!")
    private Role role;
}
