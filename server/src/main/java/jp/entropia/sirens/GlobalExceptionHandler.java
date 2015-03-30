package jp.entropia.sirens;

import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 認証はしているが、リソースを操作する権限がない場合に403を返す
	 */
	@ExceptionHandler(value = ForbiddenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
    public void ForbiddenException() {}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void ResourceNotFoundException() {}

}
