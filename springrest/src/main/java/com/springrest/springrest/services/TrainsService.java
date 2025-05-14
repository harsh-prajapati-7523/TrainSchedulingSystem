package com.springrest.springrest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.Database.Train;
import com.springrest.springrest.entities.TrainDto;
@Service
public interface TrainsService {
	
	public List<TrainDto> getTrains();
	
	public TrainDto findTrainByNum(long number);

	public void removeTrainByNumber(long number);

	public void updateTrainByNum(TrainDto train);

	public TrainDto addTrain(TrainDto train);
	

}
