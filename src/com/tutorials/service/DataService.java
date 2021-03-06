package com.tutorials.service;

import java.util.List;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Relation;
import com.tutorials.domain.Patient;

public interface DataService {
	public int insertRow(Patient patient);

	public void updatePatient(Integer Id, Patient patient);

	public List<Integer> getPatientDoctors(Integer patientId);

	public List<Patient> getRecentPatinets(Integer[] interval);

	public Integer getLastId();

	public Patient getPatient(int Id);

	public List<Doctor> getAll();

	public Iterable<DHXEv> getEvent();

	public DHXStatus saveEvent(DHXEv event, DHXStatus status);

	public List<String> getHospitalsName();

	public Object getHospitalIdByName(String name);

	public List<Doctor> getDoctorsFromHospital(Integer hospitalId);

	public Doctor getDoctorById(Integer doctorId);

	public Integer insertMedCard(Relation card) throws Exception;
}
