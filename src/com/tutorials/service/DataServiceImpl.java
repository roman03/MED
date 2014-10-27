package com.tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorails.dao.*;
import com.tutorials.domain.Patient;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	DataDao dataDao;
	
	@Override
	public int insertRow(Patient patient) {
		return dataDao.insertRow(patient);
	}

}
