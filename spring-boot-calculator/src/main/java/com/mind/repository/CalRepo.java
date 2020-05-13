package com.mind.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mind.model.CalRequest;
import com.mind.model.ReplayReq;
import com.mind.model.Response;

@Repository
public class CalRepo {
    public static List<Response> listOperations =  new ArrayList<Response>(); 
	public Response operations(CalRequest cal) {
		Response resp = new Response();
		Double result = 0.0;
		if (cal.getOperation().equals("ADD")) {
			result = cal.getNumber1() + cal.getNumber2();
			resp.setResult("Sum of " + cal.getNumber1() + " and " + cal.getNumber2() + " is " + result);
			listOperations.add(resp);
			return resp;
		} else if (cal.getOperation().equals("SUBTRACT")) {
			result = cal.getNumber1() - cal.getNumber2();
			resp.setResult("SUBTRACT of " + cal.getNumber1() + " and " + cal.getNumber2() + " is " + result);
			listOperations.add(resp);
			return resp;
		} else if (cal.getOperation().equals("DIVIDE")) {
			result = cal.getNumber1() / cal.getNumber2();
			resp.setResult("DIVIDE of " + cal.getNumber1() + " and " + cal.getNumber2() + " is " + result);
			listOperations.add(resp);
			return resp;
		} else if (cal.getOperation().equals("MULTIPLY")) {
			result = cal.getNumber1() * cal.getNumber2();
			resp.setResult("MULTIPLY of " + cal.getNumber1() + " and " + cal.getNumber2() + " is " + result);
			listOperations.add(resp);
			return resp;

		} else if (cal.getOperation().equals("MODULO")) {
			result = cal.getNumber1() % cal.getNumber2();
			resp.setResult("MODULO of " + cal.getNumber1() + " and " + cal.getNumber2() + " is " + result);
			listOperations.add(resp);
			return resp;
		}
		return resp;
	}
	
 public List<Response> getAllCalculatedOperations(){
	 return listOperations;
	 
 }

	public Response getSpecifiedOperation(ReplayReq rpReq) {
		int seqno = rpReq.getReplaySeq();
		return listOperations.get(seqno);

	}
}
