package com.api.CalculadoraRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.CalculadoraRest.model.Calculator;

public interface CalculatorRepository extends JpaRepository<Calculator, Long> {

}
