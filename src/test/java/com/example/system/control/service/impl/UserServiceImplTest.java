package com.example.system.control.service.impl;

import com.example.system.control.dto.UserDto;
import com.example.system.control.entity.Users;
import com.example.system.control.enums.Role;
import com.example.system.control.repository.UserRepository;
import com.example.system.control.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder encoder;

    @InjectMocks // Инъекция мока в сервис
    private UserService service = new UserServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Проверка сервиса не null")
    void UserServiceTest() {
        Assertions.assertNotNull(service);
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    void registerUser_Success() {
        UserDto userDto = new UserDto("example@gmail.com", "password123", Role.USER);

        when(repository.existsByEmail(userDto.getEmail())).thenReturn(false);
        when(encoder.encode(userDto.getPassword())).thenReturn("encodedPassword");

        service.registerUser(userDto);

        verify(repository, times(1)).save(any(Users.class));
    }

    @Test
    @DisplayName("Проверка регистрации с пустым email")
    void registerUser_NullEmail_ThrowsException() {
        UserDto userDto = new UserDto(null, "password123", Role.USER);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.registerUser(userDto);
        });

        assertEquals("Email является пустым!", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка регистрации с существующим email")
    void registerUser_ExistingEmail_ThrowsException() {
        UserDto userDto = new UserDto("example@gmail.com", "password123", Role.USER);

        when(repository.existsByEmail(userDto.getEmail())).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.registerUser(userDto);
        });

        assertEquals("Пользователь с таким example@gmail.com уже существует!", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка исключения при сохранении пользователя")
    void registerUser_SaveException_ThrowsException() {
        UserDto userDto = new UserDto("newuser@gmail.com", "password123", Role.USER);

        when(repository.existsByEmail(userDto.getEmail())).thenReturn(false);
        when(encoder.encode(userDto.getPassword())).thenReturn("encodedPassword");

        // Эмулируем исключение при сохранении
        doThrow(new RuntimeException("Ошибка при сохранении")).when(repository).save(any(Users.class));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.registerUser(userDto);
        });

        assertEquals("Произошла ошибка при попытке сохранить пользователя: Ошибка при сохранении.", exception.getMessage());
    }
}