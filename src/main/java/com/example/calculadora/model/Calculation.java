package com.example.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
	
	private Integer firstOperand;
	
	private Integer secondOperand;
	
	private String operationType;
	
	private float resultFloat;
	
	private Integer resultInteger;
	
	public float getResultFloat() {
		return resultFloat;
	}

	public void setResultFloat(float result) {
		this.resultFloat = result;
	}
	
	public Integer getResultInteger() {
		return resultInteger;
	}

	public void setResultInteger(Integer result) {
		this.resultInteger = result;
	}

	private List<String> messages = new ArrayList();



	public List<String> getMessages() {
		return messages;
	}

	public void setMessage(List<String> messages) {
		this.messages = messages;
	}

	public Integer getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(Integer firstOperand) {
		this.firstOperand = firstOperand;
	}

	public Integer getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(Integer secondOperand) {
		this.secondOperand = secondOperand;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	
	@Override
	public String toString() {
		return "Operation [firstOperand=" + firstOperand + ", secondOperand=" + secondOperand + ", operationType="
				+ operationType + "]";
	}

}
