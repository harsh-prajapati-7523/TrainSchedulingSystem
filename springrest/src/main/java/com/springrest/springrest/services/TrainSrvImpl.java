package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Database.Train;
import com.springrest.springrest.dao.SearchTrainTableOne;
import com.springrest.springrest.entities.TrainDto;

@Service
public class TrainSrvImpl implements TrainsService {
	 
	@Autowired
	private SearchTrainTableOne srchTrn;

	@Override
	public List<TrainDto> getTrains() {
		return srchTrn.findAll();
	}

	@Override
	public TrainDto findTrainByNum(long number) {
		return srchTrn.getOne(number);
	} 
	@Override
	public TrainDto addTrain(TrainDto train) {
		return srchTrn.save(train);
	}
	@Override
	public void removeTrainByNumber(long number) {
		srchTrn.deleteById(number);
	}
	@Override
	public void updateTrainByNum(TrainDto train) {
		srchTrn.save(train);
	}

	




	
}
