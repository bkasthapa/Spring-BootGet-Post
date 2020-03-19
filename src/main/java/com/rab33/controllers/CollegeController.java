package com.rab33.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab33.dtos.CollegeDto;
import com.rab33.services.CollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	@GetMapping(value = "/{id}")
	public CollegeDto getColleges(@PathVariable("id") int id) {
		return collegeService.getCollegeInfo(id);

	}

	@PostMapping(value = "")
	public void addCollegeInfo(@RequestBody CollegeDto Dto) {
		collegeService.createColleges(Dto);
	}
}
