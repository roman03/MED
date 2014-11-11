package com.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;
import com.tutorails.dao.DataDao;
import com.tutorials.domain.Analyzes;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Hospital;
import com.tutorials.domain.Patient;
import com.tutorials.domain.Procedures;
import com.tutorials.domain.Relation;
import com.tutorials.domain.Remedies;
import com.tutorials.domain.Treatment;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	DataDao dataDao;

	@Override
	public int insertRow(Patient patient) {
		return dataDao.insertRow(patient);
	}

	public List<Patient> getRecentPatinets(Integer[] interval) {
		return dataDao.getRecentPatinets(interval);
	}

	@Override
	public Integer getLastId() {
		return dataDao.getLastId();
	}

	@Override
	public Patient getPatient(int Id) {
		return dataDao.getPatient(Id);
	}

	@Override
	public List<Doctor> getAll() {
		return dataDao.getAll();
	}

	@Override
	public Iterable<DHXEv> getEvent() {
		return dataDao.getEvent();
	}

	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		return dataDao.saveEvent(event, status);
	}

	@Override
	public List<String> getHospitalsName() {
		return dataDao.getHospitalsName();
	}

	@Override
	public Object getHospitalIdByName(String name) {
		return dataDao.getHospitalIdByName(name);
	}

	@Override
	public List<Doctor> getDoctorsFromHospital(Integer hospitalId) {
		return dataDao.getDoctorsFromHospital(hospitalId);
	}

	@Override
	public Integer insertMedCard(Relation card) throws Exception {
		return dataDao.insertMedCard(card);
	}

	@Override
	public void updatePatient(Integer Id, Patient patient) {
		dataDao.updatePatient(Id, patient);

	}

	@Override
	public List<Integer> getPatientDoctors(Integer patientId) {
		return dataDao.getPatientDoctors(patientId);
	}

	@Override
	public Doctor getDoctorById(Integer doctorId) {
		return dataDao.getDoctorById(doctorId);
	}

	@Override
	public Hospital getHospital(Integer hospitalId) {
		return dataDao.getHospital(hospitalId);
	}

	@Override
	public Integer addAnalyzes(Analyzes analizes) {
		return dataDao.addAnalyzes(analizes);
	}

	@Override
	public Integer addTreatment(Treatment treatment) {
		return dataDao.addTreatment(treatment);
	}

	@Override
	public Integer addProcedures(Procedures procedure) {
		return dataDao.addProcedures(procedure);
	}

	@Override
	public Integer addRemedies(Remedies remedies) {
		return dataDao.addRemedies(remedies);
	}

}
