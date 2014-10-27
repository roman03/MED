package com.tutorails.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorials.domain.Patient;
@Repository
public class DataDaoImpl implements DataDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insertRow(Patient patient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(patient);
		tx.commit();
		Serializable id = session.getIdentifier(patient);
		session.close();
		return (Integer) id;
	}

}
