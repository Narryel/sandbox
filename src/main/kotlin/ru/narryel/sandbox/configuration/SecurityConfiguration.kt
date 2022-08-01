package ru.narryel.sandbox.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { auth ->
            auth
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/test/**").permitAll()
                .anyRequest().authenticated()
        }
            .formLogin()
            .and()
            .logout().invalidateHttpSession(true)
        return http.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder(12)

    @Bean
    fun userDetailsService() = InMemoryUserDetailsManager(
        User.builder()
            .username("narryel")
            .password("\$2a\$12\$ItIPPHlXcssN3d7ZkmoZSuEt.nSyEXqdwhr7wLXku7ISgjirbLWxq")
            .roles("ADMIN")
            .build()
    )
}