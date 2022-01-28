package com.juan.estevez.app.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Se encarga de crear usuarios en memoria y restringir path's a ciertos
 * usuarios que no sean administradores.
 * 
 * @author Juan Carlos Estevez Vargas.
 *
 */
@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Autenticación (Crear roles en memoria).
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ADMIN").password("{noop}123").roles("ADMIN", "USER").and()
				.withUser("USER").password("{noop}123").roles("USER");
	}

	/**
	 * Autorización (Restringir path's a usuarios que no sean administradores).
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/edit/**", "/add/**", "/delete/**").hasRole("ADMIN").antMatchers("/")
				.hasAnyRole("ADMIN", "USER").and().formLogin().loginPage("/login").and().exceptionHandling()
				.accessDeniedPage("/errors/403");
	}
}
