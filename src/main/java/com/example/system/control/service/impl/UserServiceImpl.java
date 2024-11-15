package com.example.system.control.service.impl;

import com.example.system.control.dto.UserDto;
import com.example.system.control.entity.User;
import com.example.system.control.repository.UserRepository;
import com.example.system.control.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Сервис для управления пользователями.
 * Предоставляет методы для регистрации пользователей.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * Регистрация нового пользователя.
     *
     * @param userDto Объект, содержащий данные пользователя для регистрации.
     * @throws RuntimeException Если email пуст, пользователь с таким email уже существует
     * или произошла ошибка при отправке сообщения.
     */
    @Override
    public void registerUser(UserDto userDto) {
        if (userDto.getEmail() == null)
            throw new RuntimeException(String.format("%s является пустым!", userDto));
        if (repository.existsByEmail(userDto.getEmail()))
            throw new RuntimeException(String.format("Пользователь с таким %s уже существует!", userDto.getEmail()));

        try {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(encoder.encode(userDto.getEmail()).getBytes());
            user.setRole(userDto.getRole());
            repository.save(user);
        } catch (Exception e) {
            String.format("Произошла ошибка при попытке сохранить пользователя: %s.", e.getMessage());
        }
    }
}
