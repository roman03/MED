package com.tutorialspoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tutorials.domain.Patient;

@Component
public class NewPatientValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Patient.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Patient patient = (Patient) arg0;

		if (patient.getName() == null || patient.getName().isEmpty()) {
			errors.rejectValue("name", "Name can`t be empty",
					"Name can`t be empty");
		}

		if (patient.getFirstname() == null || patient.getFirstname().isEmpty()) {
			errors.rejectValue("firstname", "First Name can`t be empty",
					"First Name can`t be empty");
		}

		if (patient.getLastname() == null || patient.getLastname().isEmpty()) {
			errors.rejectValue("lastname", "Last Name can`t be empty",
					"Last Name can`t be empty");
		}

	}

}
