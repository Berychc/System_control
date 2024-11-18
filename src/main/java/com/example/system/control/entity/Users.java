package com.example.system.control.entity;

import com.example.system.control.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Сущность пользователя, представляющая сущность 'User' в базе данных.
 * Содержит информацию о пользователе.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {

    /**
     * Уникальный идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Электронная почта пользователя.
     */
    @Schema(description = "Почта пользователя")
    @Column(name = "email")
    private String email;

    /**
     * Пароль пользователя.
     */
    @Schema(description = "Пароль пользователя")
    @Column(name = "password")
    private String password;

    /**
     * Роль пользователя (MODERATOR, USER).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @JsonIgnore
    private Role role;
}
