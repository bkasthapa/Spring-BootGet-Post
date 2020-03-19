package com.rab33.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rab33.entities.CollegeEntity;

@Repository
public interface CollegeRepository extends CrudRepository<CollegeEntity, Integer> {

}
