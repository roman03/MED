package com.tutorails.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
import com.tutorials.domain.Analyzes;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Hospital;
import com.tutorials.domain.Patient;
import com.tutorials.domain.Procedures;
import com.tutorials.domain.Relation;
import com.tutorials.domain.Remedies;
import com.tutorials.domain.Treatment;

@Repository
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	private static final Logger log = Logger.getLogger(DataDao.class);

	@Override
	@Transactional
	public int insertRow(Patient patient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(patient);
		} catch (Exception ex) {
			log.error("insert patient exeption " + ex.getMessage());
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
		Criteria criteria = session.createCriteria(Patient.class).setProjection(Projections.max("id"));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorsFromHospital(Integer hospitalId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Doctor.class);
		criteria.add(Restrictions.eq("hospitalId", hospitalId));
		return criteria.list();
	}

	@Override
	public Integer insertMedCard(Relation card) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(card);
		tx.commit();
		Serializable id = session.getIdentifier(card);
		session.close();
		return (Integer) id;
	}

	@Override
	public void updatePatient(Integer Id, Patient patient) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Patient oldPatient = (Patient) session.get(Patient.class, Id);
			oldPatient.setPatient(patient);
			session.update(oldPatient);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				log.error("update patient exeption " + e.getMessage());
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getPatientDoctors(Integer patientId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Relation.class);
		criteria.setProjection(Projections.property("doctorId"));
		criteria.add(Restrictions.eq("patientId", patientId));
		return criteria.list();
	}

	@Override
	public Doctor getDoctorById(Integer doctorId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Doctor.class);
		criteria.add(Restrictions.eq("id", doctorId));
		return (Doctor) criteria.uniqueResult();
	}

	@Override
	public Hospital getHospital(Integer hospitalId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Hospital.class);
		criteria.add(Restrictions.eq("id", hospitalId));
		return (Hospital) criteria.uniqueResult();
	}

	@Override
	public Integer addAnalyzes(Analyzes analizes) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(analizes);
		} catch (Exception ex) {
			log.error("add analyzes execption " + ex.getMessage());
			return -1;
		}
		tx.commit();
		Serializable id = session.getIdentifier(analizes);
		session.close();
		return (Integer) id;

	}

	@Override
	public Integer addTreatment(Treatment treatment) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(treatment);
		} catch (Exception ex) {
			log.error("add Treatment exception " + ex.getMessage());
			return -1;
		}
		tx.commit();
		Serializable id = session.getIdentifier(treatment);
		session.close();
		return (Integer) id;
	}

	@Override
	public Integer addProcedures(Procedures procedure) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(procedure);
		} catch (Exception ex) {
			log.error("add procedures exception " + ex.getMessage());
			return -1;
		}
		tx.commit();
		Serializable id = session.getIdentifier(procedure);
		session.close();
		return (Integer) id;
	}

	@Override
	public Integer addRemedies(Remedies remedies) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(remedies);
		} catch (Exception ex) {
			log.error("add remedies exeption " + ex.getMessage());
			return -1;
		}
		tx.commit();
		Serializable id = session.getIdentifier(remedies);
		session.close();
		return (Integer) id;
	}
}
