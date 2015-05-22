package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.RoleDao;
import jp.entropia.sirens.entity.EntryInfo;
import jp.entropia.sirens.entity.Role;
import jp.entropia.sirens.entity.RoleEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public boolean save(Role role) {
		return roleDao.insert(role) > 0;
	}
	
	public List<RoleEntity> findAll(Integer eventId) {
		return roleDao.selectAll(eventId);
	}

	public boolean update(Role role) {
		return roleDao.update(role) > 0;
	}

	public Role select(Integer roleId) {
		return roleDao.selectById(roleId);
	}
	
	public void removeByEventId(Integer eventId) {
		roleDao.deleteByEventId(eventId);
	}
	
	public boolean isJoinedUser(Integer roleId, String userId) {
		return roleDao.selectUserId(roleId, userId) != null;
	}
	
	public List<EntryInfo> findRoleInfo(String userId, Integer eventId) {
		return roleDao.selectEntryInfo(userId, eventId);
	}
	
}
