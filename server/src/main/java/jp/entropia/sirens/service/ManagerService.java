package jp.entropia.sirens.service;

import jp.entropia.sirens.dao.ManagerDao;
import jp.entropia.sirens.entity.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerDao managerDao;
	
	public boolean save(Manager manager) {
		return managerDao.insert(manager) > 0;
	}
	
	/**
	 * ユーザがイベントの管理者であるか判定する
	 * @param eventId イベントID
	 * @param userId ユーザID
	 * @return
	 */
	public boolean isManager(Integer eventId, String userId) {
		return managerDao.isAdmin(eventId, userId);
	}

	public boolean remove(Manager manager) {
		return managerDao.delete(manager) > 0;
	}
	
	public void removeByEventId(Integer eventId) {
		managerDao.deleteByEventId(eventId);
	}

}
