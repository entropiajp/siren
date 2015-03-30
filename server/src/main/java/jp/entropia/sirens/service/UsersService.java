package jp.entropia.sirens.service;

import java.util.UUID;

import jp.entropia.sirens.dao.AuthoritiesDao;
import jp.entropia.sirens.dao.UserprofileDao;
import jp.entropia.sirens.dao.UsersDao;
import jp.entropia.sirens.entity.Authorities;
import jp.entropia.sirens.entity.User;
import jp.entropia.sirens.entity.Userprofile;
import jp.entropia.sirens.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	private final UsersDao usersDao;
	private final AuthoritiesDao authoritiesDao;
	private final UserprofileDao userprofileDao;

	@Autowired
	public UsersService(UsersDao usersDao, AuthoritiesDao authoritiesDao,
			UserprofileDao userprofileDao) {
		this.usersDao = usersDao;
		this.authoritiesDao = authoritiesDao;
		this.userprofileDao = userprofileDao;
	}
	
	public User getCurrentUser(String userid) {
		return usersDao.selectUserInfo(userid);
	}

	public void createUser(String userId, Connection<?> connection) {
		org.springframework.social.connect.UserProfile profile = connection.fetchUserProfile();
		
		Users users = new Users();
		users.setUsername(userId);
		users.setPassword(UUID.randomUUID().toString());
		users.setEnabled(1);
		usersDao.insert(users);
		
		Authorities authorities = new Authorities();
		authorities.setUsername(userId);
		authorities.setAuthority("USER");
		authoritiesDao.insert(authorities);
		
		Userprofile userProfile = new Userprofile();
		userProfile.setUserid(userId);
		userProfile.setEmail(profile.getEmail());
		userProfile.setName(profile.getName());
		userProfile.setFirstname(profile.getFirstName());
		userProfile.setLastname(profile.getLastName());
		userProfile.setUsername(profile.getUsername());
		userprofileDao.insert(userProfile);
	}
}
