package com.wipro.mhrs.util;

public class PatientNotFoundException extends Exception {
	@Override
	public String toString(){
		return "The patientID entered does exist";
	}
}