package com.app.config;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppConfig {
	public static Locale getLocale() {
//		Locale l = new Locale("en", "US");
		Locale l2 = Locale.of("en", "US");
		return l2;
	}
	
	public static String getSecretData(String key) {
		ResourceBundle rb;
		rb = ResourceBundle.getBundle("authData", getLocale()); 
		
		return rb.getString(key);
	}
	
	public static String getDateTime(int style) {
		Date date = new Date();// this stores current date and time
		DateFormat dtf = DateFormat.getDateInstance(style, Locale.of("zh", "CN"));
		return dtf.format(date);	
	}
	
	public static String getCurrency() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("ja", "JP"));
		return nf.format(10000.5);
		
	}
	
	public static String ERROR_LOG(String msg) {
		String RED_COLOR = "\u001B[32m";
		return RED_COLOR+getDateTime(0) + " TYPE : ERR " + msg;
	}
	
	public static void INFO_LOG() {
		
	}

	public static void SUCCESS_LOG() {
	
	}
	
	public static void main(String s []) {
		System.out.println(getCurrency());
	}

}
