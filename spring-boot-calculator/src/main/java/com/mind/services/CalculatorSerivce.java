package com.mind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mind.model.CalRequest;
import com.mind.model.ReplayReq;
import com.mind.model.Response;
import com.mind.repository.CalRepo;

@Service
public class CalculatorSerivce {

	@Autowired
	CalRepo calRepo;

	public List<Response> getAll() {
		return calRepo.getAllCalculatedOperations();
	}

	public Response calculator(CalRequest cal) {
		return calRepo.operations(cal);

	}

	

	public Response getSpecifiedOperation(ReplayReq rpreq) {
		return calRepo.getSpecifiedOperation(rpreq);

	}
}