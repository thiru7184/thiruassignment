package com.mind.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mind.exception.InvalidNumberFoundException;
import com.mind.model.CalRequest;
import com.mind.model.ReplayReq;
import com.mind.model.Response;
import com.mind.services.CalculatorSerivce;

import io.swagger.annotations.ApiOperation;

@RestController
public class CalculatorController {
	@Autowired
	CalculatorSerivce calculatorSerivce;
	
	@SuppressWarnings("null")
	@ApiOperation(value = "Calculator operations")
	@PostMapping("/calculator/operations")
	public ResponseEntity<Response> sumOfTwo(@RequestBody CalRequest cal) throws InvalidNumberFoundException{
	return ResponseEntity.ok().body(calculatorSerivce.calculator(cal));
	}
	
	@ApiOperation(value = "get all Calculated operations")
	@GetMapping("/allOperation")
	public ResponseEntity<List<Response>> getAllOperations() {
		return new ResponseEntity<List<Response>>(calculatorSerivce.getAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "get specified operation")
	@PostMapping("/getSpecifiedOperation")
	public ResponseEntity<Response> getSpecifiedOperation(@RequestBody ReplayReq replayReq) {
		return ResponseEntity.ok().body(calculatorSerivce.getSpecifiedOperation(replayReq));
	}
}
