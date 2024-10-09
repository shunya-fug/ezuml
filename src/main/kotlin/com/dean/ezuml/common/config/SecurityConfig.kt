package com.dean.ezuml.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

/**
 * セキュリティ設定
 */
@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests {
            it.requestMatchers("/login", "/api/csrf").permitAll()
                .requestMatchers("/css/**", "/js/**", "/plugins/**").permitAll()
                .anyRequest().authenticated()
        }
        http.csrf {
            it.ignoringRequestMatchers("/login", "/api/csrf", "/api/uml/**")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        }
        http.formLogin {
        }
        return http.build()
    }

}
