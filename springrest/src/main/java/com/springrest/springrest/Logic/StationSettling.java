package com.springrest.springrest.Logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Database.Train;
import com.springrest.springrest.dao.SearchTrainTableOne;
import com.springrest.springrest.entities.TrainDto;
import com.springrest.springrest.services.TrainSrvImpl;
import com.springrest.springrest.services.TrainSrvImpl2;
import com.springrest.springrest.services.TrainsService; 
@Service
public class StationSettling {
	@Autowired
	private TrainSrvImpl2 trainSrvImpl2;
	private SearchTrainTableOne scrhTrain; 
	
	public StationSettling(SearchTrainTableOne scrhTrain) {
		this.scrhTrain = scrhTrain;
	}

	private final TrainsService trainsService = null;

	public void AddingTrainSegregatingStations(TrainDto trainDto) {
		System.out.println("Entring AddingTrainSegregatingStations");
		long number = trainDto.getNumber();
		String trainName = trainDto.getName();
		ArrayList<String>  LstOfStations = trainDto.getStations();
		
		
		for(int i = 0 ; i < LstOfStations.size() ; i++) {
			Train train = new Train();
			
			train.setNumber(number);
			train.setName(trainName);
			train.setStationName(LstOfStations.get(i));
			if(LstOfStations.size() - 1 > i)
				{
				train.setNxtStationId(LstOfStations.get(i+1));
				}
			else {
				train.setNxtStationId("TrainTerminatesHere");
			}
			
			trainSrvImpl2.addTrain2(train);
		}
		
		
		
 }
}
