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
	private Integer analyzesId;

	@Column(name = "PROCEDURESID")
	private Integer proceduresId;

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

	public Integer getAnalyzesId() {
		return analyzesId;
	}

	public void setAnalyzesId(Integer analyzesId) {
		this.analyzesId = analyzesId;
	}

	public Integer getProceduresId() {
		return proceduresId;
	}

	public void setProceduresId(Integer proceduresId) {
		this.proceduresId = proceduresId;
	}

}
