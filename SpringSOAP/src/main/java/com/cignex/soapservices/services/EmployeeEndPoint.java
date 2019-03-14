package com.cignex.soapservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cignex.soapmodel.GetEmployeeRequest;
import com.cignex.soapmodel.GetEmployeeResponse;

@Endpoint
public class EmployeeEndPoint {

	@Autowired
	EmployeeService service;

	@PayloadRoot(namespace = "http://cignex.com/soapmodel", localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse employeeRequest(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		response.setEmployee(service.getemp(request.getId()));
		return response;
	}

}
