package com.juan.estevez.app.controllers;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Clase de configuración de la aplicación.
 * 
 * @author Juan Carlos Estevez Vargas
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Se encarga de cargar la página web en un idioma especificado.
	 * 
	 * @return objeto de tipo SessionLocaleResolver.
	 */
	@Bean
	public LocaleResolver localeResolver() {
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("en"));
		return slr;
	}

	/**
	 * Se encarga de interceptar el idioma por parámetro "lang".
	 * 
	 * @return objeto de tipo LocaleChangeInterceptor.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		registro.addInterceptor(localeChangeInterceptor());
	}

	/**
	 * Se encarga de registrar las vistas que no pasen por un controlador.
	 * 
	 * @param registry objeto encargado de registrar cada vista.
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login");
		registry.addViewController("/errors/403").setViewName("/errors/403");
	}
}
