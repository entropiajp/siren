package jp.entropia.sirens.controller;

import java.security.Principal;

import jp.entropia.sirens.entity.User;
import jp.entropia.sirens.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="")
	public User getUser(Principal principal) {
		return usersService.getCurrentUser(principal.getName());
	}
}
