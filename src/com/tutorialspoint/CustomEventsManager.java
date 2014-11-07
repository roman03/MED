package com.tutorialspoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.tutorials.service.DataService;

public class CustomEventsManager extends DHXEventsManager {

	@Autowired
	DataService dataService;

	public CustomEventsManager(HttpServletRequest request) {
		super(request);
	}

	public Iterable<DHXEv> getEvents() {
		return dataService.getEvent();
	}

	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		return dataService.saveEvent(event, status);
	}

	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		return new DHXEvent();
	}
}
