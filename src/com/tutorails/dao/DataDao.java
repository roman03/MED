package com.tutorails.dao;

import java.util.List;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Relation;
import com.tutorials.domain.Patient;

public interface DataDao {
	public int insertRow(Patient patient);

	public void updatePatient(Integer Id, Patient patient);

	public List<Patient> getRecentPatinets(Integer[] interval);

	public List<Integer> getPatientDoctors(Integer patientId);

	public Integer getLastId();

	public Patient getPatient(int Id);

	public List<Doctor> getAll();

	public Iterable<DHXEv> getEvent();

	public DHXStatus saveEvent(DHXEv event, DHXStatus status);

	public List<String> getHospitalsName();

	public Object getHospitalIdByName(String name);

	public List<Doctor> getDoctorsFromHospital(Integer hospitaId);

	public Doctor getDoctorById(Integer doctorId);

	public Integer insertMedCard(Relation card) throws Exception;
}
