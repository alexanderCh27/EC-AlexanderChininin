package com.idat.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encript {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("1234"));
	}
}
