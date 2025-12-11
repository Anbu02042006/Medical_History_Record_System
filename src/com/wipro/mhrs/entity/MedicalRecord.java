package com.wipro.mhrs.entity;


public class MedicalRecord {
	private String recordId;
	private String patientId;
	private String date;
	private String diagnosis;
	private String treatment;
	private String doctorNotes;
	public MedicalRecord(String recordId, String patientId, String date, String diagnosis, String treatment,
			String doctorNotes) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		this.date = date;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.doctorNotes = doctorNotes;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patient) {
		this.patientId = patient;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDoctorNotes() {
		return doctorNotes;
	}
	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}

}