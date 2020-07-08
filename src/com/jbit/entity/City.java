package com.jbit.entity;

import java.util.ArrayList;
import java.util.List;

public class City {
	private int cityId;
	private String cityName;
	List<Info> infos = new ArrayList<Info>();
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Info> getInfos() {
		return infos;
	}
	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}
	
	
	
}
