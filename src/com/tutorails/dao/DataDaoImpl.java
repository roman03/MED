package com.tutorails.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXStatus;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Hospital;
import com.tutorials.domain.Patient;

@Repository
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insertRow(Patient patient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(patient);
		} catch (Exception ex) {
			return -1;
		}
		tx.commit();
		Serializable id = session.getIdentifier(patient);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<Patient> getRecentPatinets(Integer[] interval) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Patient.class);
		criteria.add(Restrictions.in("id", interval));
		@SuppressWarnings("unchecked")
		List<Patient> employees = (List<Patient>) criteria.list();
		return employees;
	}

	@Override
	public Integer getLastId() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Patient.class)
				.setProjection(Projections.max("id"));
		return (Integer) criteria.uniqueResult();
	}

	@Override
	public Patient getPatient(int Id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Patient.class);
		criteria.add(Restrictions.eq("id", Id));
		return (Patient) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getAll() {
		Session session = sessionFactory.openSession();
		return session.createCriteria(Doctor.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<DHXEv> getEvent() {
		Session session = sessionFactory.openSession();
		List<DHXEv> evs = new ArrayList<DHXEv>();
		try {
			session = sessionFactory.openSession();
			evs = session.createCriteria(DHXEvent.class).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		return evs;
	}

	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		Session session = sessionFactory.openSession();
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			if (status == DHXStatus.UPDATE)
				session.update(event);
			else if (status == DHXStatus.DELETE)
				session.delete(event);
			else if (status == DHXStatus.INSERT)
				session.save(event);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getHospitalsName() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Hospital.class);
		criteria.setProjection(Projections.property("name"));
		return criteria.list();
	}

	@Override
	public Object getHospitalIdByName(String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Hospital.class);
		criteria.add(Restrictions.eq("name", name));
		return criteria.uniqueResult();
	}
}
