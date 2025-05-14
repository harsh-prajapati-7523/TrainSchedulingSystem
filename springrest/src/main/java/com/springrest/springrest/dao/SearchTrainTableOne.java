package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springrest.springrest.entities.TrainDto;
@Component
public interface SearchTrainTableOne extends JpaRepository<TrainDto , Long>{
	
	
	
}
