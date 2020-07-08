package com.jbit.biz;

import java.util.List;

import com.jbit.entity.City;
import com.jbit.entity.Info;
import com.jbit.entity.Person;
import com.jbit.entity.Train;
import java.sql.ResultSet;

public interface UserBiz {

	List<Person> getUsers(String sql,ResultSet resultset);

	List<City> getCitys(String sql,ResultSet resultset);

	List<Train> getTrains(String sql,ResultSet resultset);

	Person getInfo(int userId,ResultSet resultset);

	List<Person> getPersonsByCityId(int cityId,ResultSet resultset);

	List<Person> getPersonsByTrainId(int trainId,ResultSet resultset);

	int addPerson(Person person,ResultSet resultset);

	void addInfo(Info info,ResultSet resultset);

	void addTrain(int parseInt, int userId,ResultSet resultset);

}
