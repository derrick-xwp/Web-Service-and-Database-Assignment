package com.jbit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Train implements Serializable {

	private int trainId;
	private String trainName;
	
	List<Person> users = new ArrayList<Person>();

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public List<Person> getUsers() {
		return users;
	}

	public void setUsers(List<Person> users) {
		this.users = users;
	}
	
}
