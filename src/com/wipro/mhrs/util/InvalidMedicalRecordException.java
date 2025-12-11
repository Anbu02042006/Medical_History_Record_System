package com.wipro.mhrs.util;

public class InvalidMedicalRecordException extends Exception{
	@Override
	public String toString(){
		return "This contains invalid or empty information";
	}

}