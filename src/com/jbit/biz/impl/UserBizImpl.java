package com.jbit.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.jbit.biz.UserBiz;
import com.jbit.dao.UserDao;
import com.jbit.entity.City;
import com.jbit.entity.Info;
import com.jbit.entity.Person;
import com.jbit.entity.PersonTrain;
import com.jbit.entity.Train;
import java.sql.ResultSet;

public class UserBizImpl implements UserBiz {
	private UserDao userDao = new UserDao();
        private ResultSet resultset;
        public UserBizImpl(ResultSet rs){
        
            resultset=rs;
        
        }

	@Override
	public List<Person> getUsers(String sql,ResultSet resultset) {
		
		return userDao.getUsers(sql,resultset);
	}

	@Override
	public List<City> getCitys(String sql,ResultSet resultset) {
		
		return userDao.getCitys(sql,resultset);
	}

	@Override
	public List<Train> getTrains(String sql,ResultSet resultset) {
		
		return userDao.getTrains(sql,resultset);
	}

	@Override
	public Person getInfo(int userId,ResultSet resultset) {
		Person person = userDao.getInfo(userId,resultset);
		person.setInfo(userDao.getInfoByUserId(userId,resultset));
		person.setCityName(userDao.getcityNameByCityId(person,resultset));
		List<PersonTrain>personTrains = userDao.getTrainsByUserId(userId,resultset);
		List<Train>trains = new ArrayList<Train>();
		for (PersonTrain personTrain : personTrains) {
			Train train = userDao.getTrainByTrainId(personTrain,resultset);
			trains.add(train);
		}
		person.setTrains(trains);
		
		return person;
	}

	@Override
	public List<Person> getPersonsByCityId(int cityId,ResultSet resultset) {
		
		return userDao.getPersonsByCityId(cityId,resultset);
	}

	@Override
	public List<Person> getPersonsByTrainId(int trainId,ResultSet resultset) {
		List<Person>persons = new ArrayList<>();
		List<PersonTrain>personTrains = userDao.getTrainsByTrainId(trainId,resultset);
		for (PersonTrain personTrain : personTrains) {
			persons.add(userDao.getPersonByUserId(personTrain,resultset));
		}
		return persons;
	}

	@Override
	public int addPerson(Person person,ResultSet resultset) {
		return userDao.addPerson(person,resultset);
	}

	@Override
	public void addInfo(Info info,ResultSet resultset) {
		userDao.addInfo(info,resultset);
	}

	@Override
	public void addTrain(int trainId, int userId,ResultSet resultset) {
		userDao.addTrain(trainId,userId,resultset);
	}

}
