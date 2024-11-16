package com.example.system.control.security;

import com.example.system.control.entity.User;
import com.example.system.control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервис для загрузки деталей пользователя по его имени пользователя.
 * Реализует интерфейс UserDetailsService для интеграции с Spring Security.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    /**
     * Загружает пользователя по имени пользователя (email).
     *
     * @param username Имя пользователя (обычно это email).
     * @return UserDetails, содержащий информацию о пользователе.
     * @throws UsernameNotFoundException Если пользователь не найден по указанному имени пользователя.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        return user.map(SecurityUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("%s - не найден", username)));
    }
}
