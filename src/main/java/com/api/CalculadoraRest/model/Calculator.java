package com.api.CalculadoraRest.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Calculator")
public class Calculator {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private BigDecimal primeiroNumero;
	private BigDecimal segundoNumero;
	private BigDecimal result;
	public BigDecimal getPrimeiroNumero() {
		return primeiroNumero;
	}
	public void setPrimeiroNumero(BigDecimal primeiroNumero) {
		this.primeiroNumero = primeiroNumero; 
	}
	public BigDecimal getSegundoNumero() {
		return segundoNumero;
	}
	public void setSegundoNumero(BigDecimal segundoNumero) {
		this.segundoNumero = segundoNumero;
	}
	public BigDecimal getResult() {
		return result;
	}
	public void setResult(BigDecimal result) {
		this.result = result;
	}
	public long getId() {
		return id;
	}
	 
	
}
