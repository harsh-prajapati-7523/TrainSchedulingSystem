package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Database.Train;
import com.springrest.springrest.dao.SearchTrainTableOne;
import com.springrest.springrest.dao.SearchTrainTableTwo;
import com.springrest.springrest.entities.TrainDto;

@Service
public class TrainSrvImpl2 implements TrainService2 {
	 
	@Autowired
	private SearchTrainTableTwo srchTrn;

	public Train addTrain2(Train train) {
		return srchTrn.save(train);
	}


	

	




	
}
