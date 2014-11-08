package com.tutorials.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patients")
public class Patient {

	public Patient() {
	}

	public Patient(String firstname, String lastname, String name, String age, String sex, String address,
			String workplace) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.workplace = workplace;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private String age;

	@Column(name = "SEX")
	private String sex;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "WORKPLACE")
	private String workplace;

	@Column(name = "DIAGNOSIS")
	private String diagnosis;

	@Column(name = "DATEARRIVED")
	private String dateArrived;

	@Column(name = "ENDTREATMENT")
	private String endTreatment;

	@Column(name = "HOSPITALID")
	private Integer hospitalId;

	@Column(name = "HOSPITALNAME")
	private String hospitalName;

	public void setPatient(Patient patient) {
		name = patient.getName();
		firstname = patient.getFirstname();
		lastname = patient.getLastname();
		age = patient.getAge();
		sex = patient.getSex();
		address = patient.getAddress();
		workplace = patient.getWorkplace();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDateArrived() {
		return dateArrived;
	}

	public void setDateArrived(String dateArrived) {
		this.dateArrived = dateArrived;
	}

	public String getEndTreatment() {
		return endTreatment;
	}

	public void setEndTreatment(String endTreatment) {
		this.endTreatment = endTreatment;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
