package com.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;
import com.tutorails.dao.DataDao;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.MedCard;
import com.tutorials.domain.Patient;

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
	public Integer insertMedCard(MedCard card) throws Exception {
		return dataDao.insertMedCard(card);
	}

	@Override
	public void updatePatient(Integer Id, Patient patient) {
		dataDao.updatePatient(Id, patient);

	}

}
