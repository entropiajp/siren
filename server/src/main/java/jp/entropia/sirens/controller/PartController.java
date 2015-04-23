package jp.entropia.sirens.controller;

import java.util.List;

import jp.entropia.sirens.entity.Part;
import jp.entropia.sirens.service.PartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parts")
public class PartController {
	
	@Autowired
	private PartService partService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Part> getAll() {
		return partService.findAll();
	}

}
