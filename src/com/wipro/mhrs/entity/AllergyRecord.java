package com.wipro.mhrs.entity;

public class AllergyRecord{
	private String allergyId;
	private String patientId;
	private String allergyName;
	private String severity;
	public AllergyRecord(String allergyId, String patientId, String allergyName, String severity) {
		super();
		this.allergyId = allergyId;
		this.patientId = patientId;
		this.allergyName = allergyName;
		this.severity = severity;
	}
	public String getAllergyId() {
		return allergyId;
	}
	public void setAllergyId(String allergyId) {
		this.allergyId = allergyId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

}