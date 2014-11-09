package com.tutorials.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treatment")
public class Treatment {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "PATIENTID")
	private Integer patientId;

	@Column(name = "DOCTORID")
	private Integer doctorId;

	@Column(name = "ANALYZESID")
	private Integer analyzezId;

	@Column(name = "PROCEDYRESID")
	private Integer procedyresId;

	@Column(name = "REMEDIESID")
	private Integer remediesId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getTreatmentId() {
		return analyzezId;
	}

	public void setTreatmentId(Integer analyzezId) {
		this.analyzezId = analyzezId;
	}

	public Integer getAnalyzezId() {
		return analyzezId;
	}

	public void setAnalyzezId(Integer analyzezId) {
		this.analyzezId = analyzezId;
	}

	public Integer getProcedyresId() {
		return procedyresId;
	}

	public void setProcedyresId(Integer procedyresId) {
		this.procedyresId = procedyresId;
	}

	public Integer getRemediesId() {
		return remediesId;
	}

	public void setRemediesId(Integer remediesId) {
		this.remediesId = remediesId;
	}
}
