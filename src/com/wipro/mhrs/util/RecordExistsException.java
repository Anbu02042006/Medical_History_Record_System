package com.wipro.mhrs.util;

public class RecordExistsException extends Exception {
	@Override
	public String toString() {
		return "Patient record already exists";
	}
}
