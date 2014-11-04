package com.tutorails.dao;

import java.util.List;

import com.tutorials.domain.Patient;

public interface DataDao {
	public int insertRow(Patient patient);

	public List<Patient> getRecentPatinets(Integer[] interval);

	public Integer getLastId();

	public Patient getPatient(int Id);
}
