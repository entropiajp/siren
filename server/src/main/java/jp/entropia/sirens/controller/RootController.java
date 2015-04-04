package jp.entropia.sirens.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix="sirens")
public class RootController {
	
	private Twitter twitter;
    private ConnectionRepository connectionRepository;
    
    private String profileImageDir = "/Users/koyama/Dropbox/";

    @Autowired
    public RootController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

	@RequestMapping(value="/login")
	public String login(Principal principal){
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) throws ServletException {
		request.logout();
	}
	
	@RequestMapping(value="/")
	public String index(Principal principal) {
		saveProfileImage(principal.getName());
		return "index";
	}
	
	private void saveProfileImage(String userId) {
		String profileImageUrl = twitter.userOperations().getUserProfile().getProfileImageUrl();
		String largeImageUrl = profileImageUrl.replaceFirst("normal.", "bigger.");
		try(InputStream is = new URL(largeImageUrl).openStream()){
		    Files.copy(is, Paths.get(profileImageDir + userId + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
