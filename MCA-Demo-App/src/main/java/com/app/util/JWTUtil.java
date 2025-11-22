package com.app.util;

import java.net.SecureCacheResponse;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

//there will be two functions in this class, one will be used to create the JWT token.
//The other function will be used to verify the JWT token.
public class JWTUtil {
	static String secret = "thiscodeistopsecret";
	//here we are doing the encryption using SHA 256 (Secure Hash Algorithm --> 256 bytes)
	static Algorithm algo = Algorithm.HMAC256(secret);
	
	static Date currentDateTime = new Date(); // this has today's date and current time
	static long expireDuration = 10 * 60 * 1000;
	static long currentTime = currentDateTime.getTime();
	static Date expireDateTime = new Date(currentTime + expireDuration);
	public static void createJWT(String email, int phone, String name, int otp) {
		String token = JWT.create()
		.withSubject(email)
		.withClaim("otp", otp)
		.withClaim("userPhone", phone)
		.withClaim("userName", name)
		.withExpiresAt(expireDateTime)
		.sign(algo);
		
		System.out.println(token);
		
	}
	public static void main(String a[]) {
		createJWT("piebytwo014@gmail.com", 1234234, "Vivek", 245432);
	}
}
