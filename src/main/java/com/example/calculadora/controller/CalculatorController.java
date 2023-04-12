package com.example.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.calculadora.model.Calculation;
import com.example.calculadora.service.LogTracer;
import com.example.calculadora.service.OperationExecutionService;


@RestController
public class CalculatorController {
	
	private OperationExecutionService operationExecService;
	private LogTracer logTracer;
	
	@GetMapping("/pocOperation")
	public Calculation pocGetOperation(Calculation operation,BindingResult result) {
		
		if(result.hasErrors()) {
			operation.getMessages().add(result.getAllErrors().get(0).toString());
			return operation;
		}
		
		operationExecService.execute(operation);
		return operation;
	}
	
	
	@PostMapping("/pocOperation")
	public Calculation pocOperation(Calculation operation,BindingResult result) {
		operation.getMessages().forEach(message->{
			logTracer.logEvent(message);
		});
		operationExecService.execute(operation);
		return operation;
	}
	
	@Autowired
	public void setOperationExecService(OperationExecutionService operationExecService) {
		this.operationExecService = operationExecService;
	}
	
	@Autowired
	public void setLogTracer(LogTracer logTracer) {
		this.logTracer = logTracer;
	}

}
