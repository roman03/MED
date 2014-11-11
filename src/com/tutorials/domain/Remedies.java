package com.tutorials.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "remedies")
public class Remedies {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DOSAGE")
	private String dosage;

	@Column(name = "TIME")
	private Calendar time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}
}
