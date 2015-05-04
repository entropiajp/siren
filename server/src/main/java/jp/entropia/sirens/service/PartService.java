package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.PartDao;
import jp.entropia.sirens.entity.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartService {

	@Autowired
	private PartDao partDao;
	
	public List<Part> findAll() {
		return partDao.selectAll();
	}
}
