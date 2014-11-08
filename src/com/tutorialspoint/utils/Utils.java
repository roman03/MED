package com.tutorialspoint.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tutorials.domain.Doctor;
import com.tutorials.domain.Patient;

public class Utils {

	private final static int LAST_PATIENT_COUNT = 4;

	public static Integer[] getInterval(int lastPatientId) {
		Integer[] patients = null;
		if (lastPatientId > LAST_PATIENT_COUNT) {
			patients = new Integer[LAST_PATIENT_COUNT];
			for (int i = lastPatientId, y = 0; y < LAST_PATIENT_COUNT; i--, y++) {
				patients[y] = new Integer(i);
			}
		} else {
			patients = new Integer[lastPatientId];
			for (int i = lastPatientId, y = 0; y < lastPatientId; i--, y++) {
				patients[y] = new Integer(i);
			}
		}

		return patients;
	}

	public static Map<String, String> fillPatientMap(Patient patient) {
		Map<String, String> pationtMap = new LinkedHashMap<String, String>();
		pationtMap.put("name", patient.getName());
		pationtMap.put("firstName", patient.getFirstname());
		pationtMap.put("lastName", patient.getLastname());
		pationtMap.put("age", patient.getAge());
		pationtMap.put("sex", patient.getAge());
		pationtMap.put("address", patient.getAddress());
		pationtMap.put("workplace", patient.getWorkplace());
		pationtMap.put("diagnosis", patient.getDiagnosis());
		pationtMap.put("hospitalName", patient.getHospitalName());

		return pationtMap;
	}

	@SuppressWarnings("unchecked")
	public static JSONArray getDoctors(List<Doctor> list) {
		JSONArray jsonArray = new JSONArray();

		Iterator<Doctor> itr = list.iterator();
		while (itr.hasNext()) {
			Doctor doctor = itr.next();
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("name", doctor.getName());
			formDetailsJson.put("lastName", doctor.getLastname());
			formDetailsJson.put("post", doctor.getPost());
			formDetailsJson.put("calendarId", doctor.getCalendarId());
			formDetailsJson.put("hospitalId", doctor.getHospitalId());
			jsonArray.add(formDetailsJson);
		}
		return jsonArray;
	}
}
