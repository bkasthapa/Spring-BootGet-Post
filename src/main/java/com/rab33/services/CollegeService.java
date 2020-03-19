package com.rab33.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab33.dtos.CollegeDto;
import com.rab33.entities.CollegeEntity;
import com.rab33.repositories.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	public CollegeDto getCollegeInfo(int id) {

		Optional<CollegeEntity> collegeEntity = collegeRepository.findById(id);
		CollegeDto collegeDto = null;

		if (collegeEntity.isPresent()) {
			collegeDto = new CollegeDto();

			collegeDto.setFirstName(collegeEntity.get().getfName());
			collegeDto.setLastName(collegeEntity.get().getlName());
			collegeDto.setEmail(collegeEntity.get().getEmail());
			collegeDto.setPhoneNo(collegeEntity.get().getEmail());
			collegeDto.setId(collegeEntity.get().getId());
		}
		return collegeDto;

	}

	public void createColleges(CollegeDto collegeDto) {
		CollegeEntity collegeEntity = new CollegeEntity();
		collegeEntity.setfName(collegeDto.getFirstName());
		collegeEntity.setlName(collegeDto.getLastName());
		collegeEntity.setEmail(collegeDto.getEmail());
		collegeEntity.setPhoneNo(collegeDto.getPhoneNo());
		collegeEntity.setUpdatedAt(new Date());
		collegeEntity.setCreatAt(new Date());
		collegeEntity.setUuid(UUID.randomUUID().toString());

		collegeRepository.save(collegeEntity);
	}
}
