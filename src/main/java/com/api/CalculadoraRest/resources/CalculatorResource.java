package com.api.CalculadoraRest.resources;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.CalculadoraRest.model.Calculator;

@RestController

public class CalculatorResource {
	@Autowired
	private MessageSource messageSource;

	@ResponseBody
	@GetMapping("/sum")
	public ResponseEntity<Calculator> sum(String a, String b) {
		Calculator calculator = new Calculator();
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		try {
			BigDecimal result = new BigDecimal(a).add(new BigDecimal(b));
			calculator.setResult(result);
			return calculator != null ? ResponseEntity.ok(calculator) : ResponseEntity.notFound().build();

		} catch (NumberFormatException e) {
			String mensagemUsuario = messageSource.getMessage("valor.incorecto", null, LocaleContextHolder.getLocale());
			throw new NumberFormatException(mensagemUsuario);

		}
	}

	@GetMapping("/subtract")
	public ResponseEntity<Calculator> subtract(String a, String b) {
		Calculator calculator = new Calculator();
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		try {
			BigDecimal result = new BigDecimal(a).subtract(new BigDecimal(b));
			calculator.setResult(result);
			return calculator != null ? ResponseEntity.ok(calculator) : ResponseEntity.notFound().build();

		} catch (NumberFormatException e) {
			String mensagemUsuario = messageSource.getMessage("valor.incorecto", null, LocaleContextHolder.getLocale());
			throw new NumberFormatException(mensagemUsuario);

		}
	}

	@GetMapping("/multiply")
	public ResponseEntity<Calculator> multiply(String a, String b) {
		Calculator calculator = new Calculator();
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		try {
			BigDecimal result = new BigDecimal(a).multiply(new BigDecimal(b));
			calculator.setResult(result);
			return calculator != null ? ResponseEntity.ok(calculator) : ResponseEntity.notFound().build();
		
		} catch (NumberFormatException e) {
			String mensagemUsuario = messageSource.getMessage("valor.incorecto", null, LocaleContextHolder.getLocale());
			throw new NumberFormatException(mensagemUsuario);

		}

	}

	@GetMapping("/divide")
	public ResponseEntity<Calculator> divide(String a, String b) {
		Calculator calculator = new Calculator();
		
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		try {
			BigDecimal result = new BigDecimal(a).divide(new BigDecimal(b),BigDecimal.ROUND_UP);
			calculator.setResult(result);
			return calculator != null ? ResponseEntity.ok(calculator) : ResponseEntity.notFound().build();
		
		} catch (NumberFormatException e) {
			String mensagemUsuario = messageSource.getMessage("valor.incorecto", null, LocaleContextHolder.getLocale());
			throw new NumberFormatException(mensagemUsuario);

		}

	}
}
