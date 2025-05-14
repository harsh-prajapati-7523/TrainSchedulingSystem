package com.springrest.springrest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.TrainDto;
import com.springrest.springrest.services.TrainSrvImpl;
import com.springrest.springrest.Logic.DecliningDoubleAddition;
import com.springrest.springrest.Logic.FindingTrains;
import com.springrest.springrest.Logic.StationSettling;
import com.springrest.springrest.dao.SearchTrainTableOne;
import com.springrest.springrest.entities.NumberDto;
import com.springrest.springrest.entities.SrcDestnDto;

@RestController 
public class TrainSchedulingController {

	private final TrainSrvImpl trainServiceImplementation;
	private final StationSettling stationSettling;
	private final SearchTrainTableOne srchTrn ;
	private final FindingTrains findingTrains;
	private final DecliningDoubleAddition decliningDoubleAddition;
	@Autowired
	public TrainSchedulingController(TrainSrvImpl trainServiceImplementation,  StationSettling stationSettling , SearchTrainTableOne srchTrn , FindingTrains findingTrains , DecliningDoubleAddition decliningDoubleAddition) {
		this.trainServiceImplementation = trainServiceImplementation;
		this.stationSettling = stationSettling;
		this.srchTrn = srchTrn;
		this.findingTrains = findingTrains;
		this.decliningDoubleAddition = decliningDoubleAddition;
	}

	@GetMapping("/home")
	public String home() {
		return "This is the home Page";
	}

	@GetMapping("/trains")
	public List<TrainDto> getTrains() {
		return null;
	}

	@PostMapping("/home/trainByNumber")
	public ResponseEntity<String> getTrainByNumber(@RequestBody NumberDto numberDto) {		
		try {
			long number = numberDto.getNumber();
			TrainDto trn = trainServiceImplementation.findTrainByNum(number);
			return ResponseEntity.ok("Train with the given number "+ number+" is " + trn.getName());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to get the train name: " + e.getMessage());
		}
	}

	@PostMapping("/home/addTrain")
	public ResponseEntity<String> addTrain(@RequestBody TrainDto train) {
		try {
			String name = train.getName();
			long number = train.getNumber();
			if(decliningDoubleAddition.findTrainsWithInnerJoinAndCondition(name, number) >= 1) {
				return ResponseEntity.ok("Train is not added please try to UPDATE.");
			}else {
				stationSettling.AddingTrainSegregatingStations(train);
				trainServiceImplementation.addTrain(train);
				return ResponseEntity.ok("Train is added successfully.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to create or update train schedule: " + e.getMessage());
		}
	}
	
	

	@PostMapping("/home/removeByNumber")
	public ResponseEntity<String> removeTrainByNumber(@RequestBody NumberDto numberDto) {
		try {
			long number = numberDto.getNumber();
			trainServiceImplementation.removeTrainByNumber(number);
			decliningDoubleAddition.deleteFromTables(number);
			return ResponseEntity.ok("Train schedule deleted successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to create or update train schedule: " + e.getMessage());
		}
	}

	@PostMapping("/home/updateTrain")
	public ResponseEntity<String> updateTrainByNumber(@RequestBody TrainDto train) {
		try {
			trainServiceImplementation.updateTrainByNum(train);
			decliningDoubleAddition.UpdateFromTables(train);
			return ResponseEntity.ok("Train schedule created or updated successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to create or update train schedule: " + e.getMessage());
		}

	}
	
	@GetMapping("/home/srcDstnTrains")
	public Set<String> findTrainByStations(@RequestBody SrcDestnDto srcDestnDto) {
		String src = srcDestnDto.getSource();
		String dst =srcDestnDto.getDestination();
		return findingTrains.findTrainsWithInnerJoinAndCondition(src , dst);
		
	}

	

}
