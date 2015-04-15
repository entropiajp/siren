package jp.entropia.sirens;

import jp.entropia.sirens.exception.AlreadyJoinedException;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.exception.NotMemberException;
import jp.entropia.sirens.exception.ResourceNotFoundException;
import jp.entropia.sirens.exception.VoteLimitExceededException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ForbiddenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorMessage ForbiddenException() {
		return new ErrorMessage("管理者のみ見られるページです");
	}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void ResourceNotFoundException() {}
	
	@ExceptionHandler(value = VoteLimitExceededException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorMessage VoteLimitExceededException() {
		return new ErrorMessage("投票曲数の制限を超えています");
	}
	
	@ExceptionHandler(value = AlreadyJoinedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorMessage AlreadyJoinedException() {
		return new ErrorMessage("誰かがすでにエントリー済みです");
	}
	
	@ExceptionHandler(value = NotMemberException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorMessage NotMemberException(Exception e) {
		return new ErrorMessage("このバンオフに参加していません");
	}
	
	private class ErrorMessage {
		public String message;
		public ErrorMessage(String m) {
			this.message = m;
		}
	}

}
