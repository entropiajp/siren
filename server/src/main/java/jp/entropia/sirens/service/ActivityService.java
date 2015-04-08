package jp.entropia.sirens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
	
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private MessageSource messageSource;
	
	public void publish(String messageCode) {
		template.convertAndSend("/topic/greetings", messageSource.getMessage(messageCode, null, null));
	}

}
