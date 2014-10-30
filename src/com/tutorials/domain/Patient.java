package com.tutorials.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patients")
public class Patient {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "FIRSTNAME")
	private String firstName;

	// @Column(name = "LASTNAME")
	// private String lastName;
	//
	// @Column(name = "NAME")
	// private String name;
	//
	// @Column(name = "AGE")
	// private String age;
	//
	// @Column(name = "SEX")
	// private String sex;
	//
	// @Column(name = "ADDRESS")
	// private String address;
	//
	// @Column(name = "WORKPLACE")
	// private String workplace;
	//
	// @Column(name = "DIAGNOSIS")
	// private String diagnosis;
	//
	// @Column(name = "DATEARRIVED")
	// private String dateArrived;
	//
	// @Column(name = "ENDTREATMENT")
	// private String endTreatment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstName;
	}

	// public void setFirstname(String firstname) {
	// this.firstName = firstname;
	// }
	//
	// public String getLastname() {
	// return lastName;
	// }
	//
	// public void setLastname(String lastname) {
	// this.lastName = lastname;
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public String getAge() {
	// return age;
	// }
	//
	// public void setAge(String age) {
	// this.age = age;
	// }
	//
	// public String getSex() {
	// return sex;
	// }
	//
	// public void setSex(String sex) {
	// this.sex = sex;
	// }
	//
	// public String getAddress() {
	// return address;
	// }
	//
	// public void setAddress(String address) {
	// this.address = address;
	// }
	//
	// public String getWorkplace() {
	// return workplace;
	// }
	//
	// public void setWorkplace(String workplace) {
	// this.workplace = workplace;
	// }
	//
	// public String getDiagnosis() {
	// return diagnosis;
	// }
	//
	// public void setDiagnosis(String diagnosis) {
	// this.diagnosis = diagnosis;
	// }
	//
	// public String getDateArrived() {
	// return dateArrived;
	// }
	//
	// public void setDateArrived(String dateArrived) {
	// this.dateArrived = dateArrived;
	// }
	//
	// public String getEndTreatment() {
	// return endTreatment;
	// }
	//
	// public void setEndTreatment(String endTreatment) {
	// this.endTreatment = endTreatment;
	// }

}
