package com.example.calculadora.service;

import com.example.calculadora.model.Calculation;

public interface IOperationExecution {

	public void executeAdd(Calculation calculation);
	public void executeSubstract(Calculation calculation);
	public void executeMultiply(Calculation calculation);
	public void executeDivide(Calculation calculation);
}
