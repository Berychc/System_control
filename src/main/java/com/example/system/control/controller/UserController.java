package com.example.system.control.controller;

import com.example.system.control.dto.UserDto;
import com.example.system.control.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для управления пользователями.
 * Предоставляет методы для регистрации пользователей и я.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    /**
     * Регистрация нового пользователя.
     *
     * @param userDto Объект, содержащий данные пользователя для регистрации.
     * @return ResponseEntity с сообщением о результате регистрации.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            service.registerUser(userDto);
            return ResponseEntity.ok("Пользователь успешно зарегистрирован!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка: " + e.getMessage());
        }
    }
}
