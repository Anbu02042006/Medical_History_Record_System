package com.wipro.mhrs.util;

public class RecordNotFoundException extends Exception{
	@Override
	public String toString() {
		return "Requested medical or allergy record does not exist";
	}

}