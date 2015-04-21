package jp.entropia.sirens.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import jp.entropia.sirens.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
    
    @Autowired
	private ActivityService activityService;
    
    @Value("${sirens.url:}")
    String url;
	
	@RequestMapping(value="/nowloading")
	public String postLogin(Principal principal) {
		activityService.publish(principal.getName(), "headline.login");
		return "redirect:" + url +"/#/portal";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) throws ServletException {
		request.logout();
	}

}
