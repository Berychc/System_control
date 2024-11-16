package com.example.system.control.security;

import com.example.system.control.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Реализация интерфейса UserDetails, представляющая пользователя в
 * контексте Spring Security.
 */
@AllArgsConstructor
public class SecurityUserDetails implements UserDetails {

    private final User user;

    /**
     * Возвращает права доступа пользователя.
     *
     * @return Коллекция прав пользователя.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    /**
     * Возвращает пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Возвращает имя пользователя (адрес электронной почты).
     *
     * @return Имя пользователя (Email).
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Проверяет, отсутствует ли срок действия учетной записи пользователя.
     *
     * @return true, если учетная запись не просрочена; иначе false.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Проверяет, заблокирована ли учетная запись пользователя.
     *
     * @return true, если учетная запись не заблокирована; иначе false.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Проверяет, истек ли срок действия учетных данных пользователя.
     *
     * @return true, если учетные данные не просрочены; иначе false.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Проверяет, активна ли учетная запись пользователя.
     *
     * @return true, если учетная запись активна; иначе false.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
