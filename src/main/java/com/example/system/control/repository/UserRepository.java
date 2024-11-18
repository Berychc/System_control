package com.example.system.control.repository;

import com.example.system.control.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы с пользователями.
 * Предоставляет методы для поиска изображений в базе данных.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    /**
     * Проверка, существует ли пользователь с указанным адресом электронной почты.
     *
     * @param email Адрес электронной почты пользователя.
     * @return true, если пользователь существует, иначе false.
     */
    boolean existsByEmail(String email);

    /**
     * Поиск пользователя по адресу электронной почты.
     *
     * @param email Адрес электронной почты пользователя.
     * @return Optional содержащий пользователя, если он найден, или пустой объект, если нет.
     */
    Optional<Users> findByEmail(String email);
}
