package com.springrest.springrest.Database;

import java.util.ArrayList;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name="Train_Number")
	private long number;
	@Column(name="Train_Name")
	private String name;
//	@Column(name = "Station")
//	private ArrayList<String> stations;
//	@Column(name ="Starting_Station")
//	private String frststation;
	@Column(name ="Next_StationId")
	private String nxtStationId;
	
	@Column(name = "StationId")
	private String stationName;
		
	
	public long getNumber() {
		return number;
	}


	public void setNumber(long number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


//	public ArrayList getStations() {
//		return stations;
//	}
//
//
//	public void setStations(ArrayList stations) {
//		this.stations = stations;
//	}

	
	

//	public String getfrststation() {
//		return frststation;
//	}
//
//
//	public void setfrststation(String station) {
//		this.frststation = station;
//	}
//
//
	public String getNxtStationId() {
		return nxtStationId;
	}


	public void setNxtStationId(String nxtStationId) {
		this.nxtStationId = nxtStationId;
	}

	
	public Train(long number, String name, ArrayList stations) {
		super();
		this.number = number;
		this.name = name;
//		this.stations = stations;
	}


	public String getStationName() {
		return stationName;
	}


	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Train [number=" + number + ", name=" + name + "]";
	}
	
		
	
}
