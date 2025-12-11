package com.wipro.mhrs.service;

import java.util.ArrayList;

import com.wipro.mhrs.entity.AllergyRecord;
import com.wipro.mhrs.entity.MedicalRecord;
import com.wipro.mhrs.entity.Patient;
import com.wipro.mhrs.util.InvalidMedicalRecordException;
import com.wipro.mhrs.util.PatientNotFoundException;
import com.wipro.mhrs.util.RecordExistsException;
import com.wipro.mhrs.util.RecordNotFoundException;

public class MedicalHistoryService {
	public ArrayList<Patient> patients;
	public ArrayList<MedicalRecord> medicalRecords;
	public ArrayList<AllergyRecord> allergyRecords;
	public MedicalHistoryService(ArrayList<Patient> patients, ArrayList<MedicalRecord> medicalRecords,ArrayList<AllergyRecord> allergyRecords) {
		this.patients = patients;
		this.medicalRecords = medicalRecords;
		this.allergyRecords = allergyRecords;
	}
	public void addPatient(Patient p) throws RecordExistsException {
		if(p==null) {
			return;
		}
		String id=p.getPatientId();
		for(Patient existId:patients) {
			if(existId.getPatientId().equals(id)) {
				throw new RecordExistsException();
			}
		}
		patients.add(p);
		System.out.println("Patient record added successfully:"+id);
	}
	public Patient findPatient(String patientId) throws PatientNotFoundException{
		for(Patient p:patients) {
			if(p.getPatientId().equals(patientId)) {
				return p;
			}
		}
		throw new PatientNotFoundException();
	}
	public void addMedicalRecord(MedicalRecord mr) throws PatientNotFoundException,InvalidMedicalRecordException{
		if(mr==null) {
			return;	
		}
		findPatient(mr.getPatientId());
		String medicalid=mr.getRecordId();
		for(MedicalRecord existId:medicalRecords) {
			if(existId.getRecordId().equals(medicalid)) {
				throw new InvalidMedicalRecordException();
			}
		}
		medicalRecords.add(mr);
		System.out.println("Medical record added successfully:"+medicalid);
	}
	public void updateMedicalRecord(String recordId,String newDiagnosis,String newTreatment,String newNotes) throws RecordNotFoundException,InvalidMedicalRecordException{
		if(recordId==null||newDiagnosis==null||newTreatment==null) {
			throw new InvalidMedicalRecordException();
		}
		for(MedicalRecord mr:medicalRecords) {
			if(mr.getRecordId().equals(recordId)){
				mr.setDiagnosis(newDiagnosis);
				mr.setTreatment(newTreatment);
				mr.setDoctorNotes(newNotes);
				return;
			}
		}
		throw new RecordNotFoundException();
	}
	public void addAllergyRecord(AllergyRecord ar) throws PatientNotFoundException,InvalidMedicalRecordException{
		if(ar==null){
			return;
		}
		if(ar.getAllergyName()==null||ar.getSeverity()==null)
			throw new InvalidMedicalRecordException();
		findPatient(ar.getPatientId());
		String allergyid=ar.getAllergyId();
		for(AllergyRecord existId:allergyRecords) {
			if(existId.getAllergyId().equals(allergyid)){
				throw new InvalidMedicalRecordException();
			}
		}
		allergyRecords.add(ar);
		System.out.println("Allergy record added successfully:"+allergyid);
	}
	public ArrayList<MedicalRecord> getMedicalHistory(String patientId) throws PatientNotFoundException{
		ArrayList<MedicalRecord> mh=new ArrayList<MedicalRecord>();
		if(patientId==null) {
			return null;
		}
		findPatient(patientId);
		for(MedicalRecord mr:medicalRecords) {
			if(mr.getPatientId().equals(patientId)){
				mh.add(mr);
			}
		}
		return mh;
	}
	public ArrayList<AllergyRecord> getAllergies(String patientId) throws PatientNotFoundException{
		ArrayList<AllergyRecord> ar=new ArrayList<AllergyRecord>();
		if(patientId==null) {
			return new ArrayList<>();
		}
		findPatient(patientId);
		for(AllergyRecord a:allergyRecords) {
			if(a.getPatientId().equals(patientId)) {
				ar.add(a);
			}
		}
		return ar;
	}
	public String generateMedicalSummary(String patientId) throws PatientNotFoundException {
		ArrayList<String> summary=new ArrayList<String>();
		try {
			Patient patient=findPatient(patientId);
			summary.add("Patient Record:"+patientId);
			summary.add("Name:"+patient.getName());
			summary.add("Age:"+patient.getAge());
			summary.add("Gender:"+patient.getGender());
			summary.add("");
			ArrayList<AllergyRecord> allergies=getAllergies(patientId);
			summary.add("Allergies");
			if(allergies.isEmpty()) {
				summary.add("No allergy record");
			}
			else {
				for(AllergyRecord ar:allergies) {
					summary.add(ar.getAllergyName()+"(Severity:)"+ar.getSeverity());
				}
				summary.add("");
			}
			ArrayList<MedicalRecord> history=getMedicalHistory(patientId);
			summary.add("Medical History");
			if(history.isEmpty()) {
				summary.add("No medical records found");
			}
			else {
				for(MedicalRecord mr:history) {
					summary.add("Record ID:"+mr.getRecordId());
					summary.add("Date:"+mr.getDate());
					summary.add("Diagnosis:"+mr.getDiagnosis());
					summary.add("Treatment:"+mr.getTreatment());
					summary.add("Notes:"+mr.getDoctorNotes());
					summary.add("");
				}
			}
		}
		catch (PatientNotFoundException e) {
			throw new PatientNotFoundException();
		}
		catch (Exception e) {
			return "An unexpected error:"+e.getMessage();
		}
		return String.join("\n",summary);
	}
}