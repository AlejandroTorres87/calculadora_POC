package com.example.calculadora.service;

import org.springframework.stereotype.Service;
import com.example.calculadora.model.Calculation;

@Service
public class OperationExecutionService implements IOperationExecution {
	
		private final String SUMA = "ADD"; 
		private final String RESTA = "SUBTRACT";
		private final String MULTIPLICACION = "MULTIPLY";
		private final String DIVISION = "DIVIDE";
		
	public Calculation	execute(Calculation calculation) {
		if (calculation.getOperationType().isEmpty() ||  calculation.getOperationType().isEmpty() || calculation.getOperationType() == null ) {
			calculation.getMessages().add("El tipo de operación no puede estar vacío, vuelve a intentarlo.");
		}
		if(calculation.getFirstOperand() == null  || calculation.getSecondOperand() == null) {
			calculation.getMessages().add("Ninguno de los operandos puedes estar vacío, vuelve a intentarlo introduciendo un valor para ambos operandos.");
		}

		if(calculation.getMessages().size() == 0){
			switch(calculation.getOperationType().toUpperCase()) {
				case SUMA:{
					executeAdd(calculation);
				}break;
				case RESTA:{
					executeSubstract(calculation);
				}break;
				case MULTIPLICACION:{
					executeMultiply(calculation);
				}break;
				case DIVISION:{
					executeDivide(calculation);
				}break;
				default:{
					setInfoMessage(calculation,false);
				}break;
			}
		}
		return calculation;
		
	}

	@Override
	public void executeAdd(Calculation calculation) {
		calculation.setResultInteger(calculation.getFirstOperand()+calculation.getSecondOperand());
		setInfoMessage(calculation,true);
	}
	
	@Override
	public void executeSubstract(Calculation calculation) {
		calculation.setResultInteger(calculation.getFirstOperand()-calculation.getSecondOperand());
		setInfoMessage(calculation,true);
	}

	@Override
	public void executeMultiply(Calculation calculation) {
		calculation.setResultInteger(calculation.getFirstOperand()*calculation.getSecondOperand());
		setInfoMessage(calculation,true);
	}

	@Override
	public void executeDivide(Calculation calculation) {
		calculation.setResultFloat((float) calculation.getFirstOperand()/ (float) calculation.getSecondOperand());
		setInfoMessage(calculation,true);
	}
	
	private void setInfoMessage(Calculation calculation,boolean exito) {
		if (exito) {
			if(calculation.getOperationType().equals(DIVISION)) {
				calculation.getMessages().add("La operación se ha realizado con éxito, el resultado es: "+calculation.getResultFloat());
			}else{
				calculation.getMessages().add("La operación se ha realizado con éxito, el resultado es: "+calculation.getResultInteger());
			}
			
		}else {
			calculation.getMessages().add("La operación solicitada no está contemplada, los valores aceptados son: ADD (sumar) y SUBTRACT (restar)");
		}
	}
	
	
}
