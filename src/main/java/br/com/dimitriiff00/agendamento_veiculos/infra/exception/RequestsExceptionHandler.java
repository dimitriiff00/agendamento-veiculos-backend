package br.com.dimitriiff00.agendamento_veiculos.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RequestsExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handle404(EntityNotFoundException ex) {
		var response = new ExceptionDTO("Dados não encontrado!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
}
