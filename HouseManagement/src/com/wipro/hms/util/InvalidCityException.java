package com.wipro.hms.util;

public class InvalidCityException  extends Exception{
	
	public InvalidCityException() {
		super("Invalid City");
	}
	
	
	public String toString() {
		
		return "Invalid City ";
		
	}

}
