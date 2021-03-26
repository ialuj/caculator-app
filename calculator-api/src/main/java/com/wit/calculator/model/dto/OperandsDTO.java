package com.wit.calculator.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe que representa o Objecto de transferencia de Dados
 * 
 */
public class OperandsDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5047915392297089803L;

	private BigDecimal firstOperand;

	private BigDecimal secondOperand;
	
	private String operationType;
	
	private BigDecimal result;

	public OperandsDTO() {
		super();
	}

	public OperandsDTO(BigDecimal firstOperand, BigDecimal secondOperand) {
		super();
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}

	public OperandsDTO(BigDecimal firstOperand, BigDecimal secondOperand, String operationType) {
		super();
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operationType = operationType;
	}

	public OperandsDTO(BigDecimal firstOperand, BigDecimal secondOperand, String operationType, BigDecimal result) {
		super();
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operationType = operationType;
		this.result = result;
	}

	public BigDecimal getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(BigDecimal firstOperand) {
		this.firstOperand = firstOperand;
	}

	public BigDecimal getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(BigDecimal secondOperand) {
		this.secondOperand = secondOperand;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Operands [firstOperand=" + firstOperand + ", secondOperand=" + secondOperand + "]";
	}

}
