package com.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorails.dao.DataDao;
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
}
