package jp.entropia.sirens.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import jp.entropia.sirens.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix="sirens")
public class RootController {
    
    @Autowired
	private ActivityService activityService;
	
	@RequestMapping(value="/nowloading")
	public String postLogin() {
		activityService.publish("headline.login");
		return "redirect:http://localhost:9000/#/portal";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) throws ServletException {
		request.logout();
	}
	
	@RequestMapping(value="/")
	public String index(Principal principal) {
		return "redirect:http://localhost:9000/#/portal";
	}

}
