package com.example.system.control.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Конфигурация безопасности приложения.
 * Определяет настройки для аутентификации и авторизации пользователей.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Конфигурация настроек HTTP безопасности.
     *
     * @param http объект HttpSecurity для настройки параметров безопасности.
     * @throws Exception если возникает ошибка в процессе настройки.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }

}
