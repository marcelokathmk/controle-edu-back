package br.com.elevaback.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler {

	@ExceptionHandler(ViolacaoChaveEstrangeiraException.class)
	public ResponseEntity<ServiceError> constraintVioletionException(ViolacaoChaveEstrangeiraException e){
		ServiceError error = new ServiceError(HttpStatus.BAD_REQUEST.value(), "Violação de chave estrangeira", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(RegistroExistenteException.class)
	public ResponseEntity<ServiceError> registroExistenteExcpetion(RegistroExistenteException e){
		ServiceError error = new ServiceError(HttpStatus.BAD_REQUEST.value(), "Registro já existente na base", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ServiceError> validation(MethodArgumentNotValidException e){
		ServiceError error = null;
		for	(FieldError fe: e.getBindingResult().getFieldErrors()) {
			error = new ServiceError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validação no campo: "+ fe.getField(), fe.getDefaultMessage());
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}
}
