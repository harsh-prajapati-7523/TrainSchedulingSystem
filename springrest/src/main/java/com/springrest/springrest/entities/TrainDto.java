package com.springrest.springrest.entities;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TrainDto {
	@Id
	@Column(name = "number")
	private long number;
	@Column(name = "name")
	private String name;
	@Column(name = "List_of_trains")
	private ArrayList<String> stations;
	
		
	
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


	public ArrayList getStations() {
		return stations;
	}


	public void setStations(ArrayList stations) {
		this.stations = stations;
	}


	public TrainDto(long number, String name, ArrayList stations) {
		super();
		this.number = number;
		this.name = name;
		this.stations = stations;
	}


	public TrainDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Train [number=" + number + ", name=" + name + ", stations=" + stations + "]";
	}
	
		
	
}
