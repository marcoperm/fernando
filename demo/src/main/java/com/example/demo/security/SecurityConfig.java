package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    /*SecurityFilterChain es utilizado para configurar y ordenar los filtros de seguridad que se aplicaran
a las peticiones http*/
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
    http
        //HttpSecurity proporciona metodos como authorizeHttpRequests
        .authorizeHttpRequests((requests) -> requests
    //para permitir acceso sin restrinciones sin necesidad de autenticar
    .requestMatchers(HttpMethod.GET).permitAll()
    .requestMatchers(HttpMethod.POST).permitAll()
    .requestMatchers("/","/index").permitAll()
    .requestMatchers("/","/convocatorias").permitAll()
    .requestMatchers("/registrar").permitAll()
    .requestMatchers("/demo/src/main/resources/static/**").permitAll()
    .requestMatchers("/comite").hasRole("comité organizador")
    .requestMatchers("/crearEvento").hasRole("comité organizador")
    .requestMatchers("/vicerrectoria").hasRole("vicerrectoria")
    //cualquier otra solicitud requiere autenticarse
    .anyRequest().authenticated())
    
    .formLogin((form) -> form
    .loginPage("/autenticar")
    .permitAll())
    .logout((logout)-> logout.permitAll());

    return http.build();
}
    /*@Bean
	public UserDetailsService userDetailsService() {
		@SuppressWarnings("deprecation")
        UserDetails user =
			User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	
    }*/
}
