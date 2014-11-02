package com.tutorials.service;

import java.util.List;

import com.tutorials.domain.Patient;

public interface DataService {
	public int insertRow(Patient patient);

	public List<Patient> getRecentPatinets(Integer[] interval);

	public Integer getLastId();
}
