package com.juan.estevez.app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Se encarga de encriptar contraseñas.
 * 
 * @author Juan Carlos Estevez Vargas.
 */
public class PasswordEncript {
	public static void main(String[] args) {
		String password = "123";
		System.out.println("password encriptado = " + passwordEncript(password));
	}

	/**
	 * Encripta la contraseña.
	 * 
	 * @param password a encriptar.
	 * @return contraseña encriptada.
	 */
	public static String passwordEncript(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
