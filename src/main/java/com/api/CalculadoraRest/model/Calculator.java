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
	
	private BigDecimal result;
	
	public BigDecimal getResult() {
		return result;
	}
	public void setResult(BigDecimal result) {
		this.result = result;
	}
	
}
