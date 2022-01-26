package com.juan.estevez.app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncript {
	public static void main(String[] args) {
		
		String password = "123";
		System.out.println("password encriptado = " + passwordEncript(password));
		
	}
	
	public static String passwordEncript(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
