package com.jbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jbit.entity.City;
import com.jbit.entity.Info;
import com.jbit.entity.Person;
import com.jbit.entity.PersonTrain;
import com.jbit.entity.Train;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class UserDao extends BaseDao {
	
	public List<Person> getUsers(String sql,ResultSet resultset) {
		List<Person>users = new ArrayList<Person>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if(sql==null) {
				sql = "select * from person";
			}
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Person person = new Person();
				person.setUserId(resultSet.getInt(1));
				person.setUserName(resultSet.getString(2));
				person.setCityId(resultSet.getInt(3));
				users.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
//		
		return users;
	}

	public List<City> getCitys(String sql,ResultSet resultset) {
		List<City>cities = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if(sql==null) {
				sql = "select * from city";
			}
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				City city = new City();
				city.setCityId(resultSet.getInt(1));
				city.setCityName(resultSet.getString(2));
				
				cities.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return cities;
	}

	public List<Train> getTrains(String sql,ResultSet resultset) {
		List<Train>trains = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if(sql == null) {
				sql = "select * from train";
			}
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Train train = new Train();
				train.setTrainId(resultSet.getInt(1));
				train.setTrainName(resultSet.getString(2));
				
				trains.add(train);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return trains;
	}

	public Person getInfo(int userId,ResultSet resultset) {
		Person person = new Person();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from person where userId = "+userId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				person.setUserId(resultSet.getInt(1));
				person.setUserName(resultSet.getString(2));
				person.setCityId(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return person;
	}

	public Info getInfoByUserId(int userId,ResultSet resultset) {
		Info info = new Info();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from info where userId = "+userId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				info.setSex(resultSet.getString(2));
				info.setAge(resultSet.getInt(3));
				info.setBorthday(resultSet.getString(4));
				info.setHight(resultSet.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return info;
	}

	public String getcityNameByCityId(Person person,ResultSet resultset) {
		String cityName = "";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select cityName from city where cityId = "+person.getCityId());
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				cityName = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return cityName;
	}

	public List<PersonTrain> getTrainsByUserId(int userId,ResultSet resultset) {
		List<PersonTrain> personTrains = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from personTrain where userId = "+userId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				PersonTrain personTrain = new PersonTrain();
				personTrain.setUserId(resultSet.getInt(1));
				personTrain.setTrainId(resultSet.getInt(2));
				personTrains.add(personTrain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return personTrains;
	}

	public Train getTrainByTrainId(PersonTrain personTrain,ResultSet resultset) {
		Train train = new Train();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from train where trainId = "+personTrain.getTrainId());
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				train.setTrainId(resultSet.getInt(1));
				train.setTrainName(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return train;
	}

	public List<Person> getPersonsByCityId(int cityId,ResultSet resultset) {
		List<Person>users = new ArrayList<Person>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from person where cityId = "+cityId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Person person = new Person();
				person.setUserId(resultSet.getInt(1));
				person.setUserName(resultSet.getString(2));
				person.setCityId(resultSet.getInt(3));
				users.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return users;
	}

	public List<PersonTrain> getTrainsByTrainId(int trainId,ResultSet resultset) {
		List<PersonTrain> personTrains = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from personTrain where trainId = "+trainId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				PersonTrain personTrain = new PersonTrain();
				personTrain.setUserId(resultSet.getInt(1));
				personTrain.setTrainId(resultSet.getInt(2));
				personTrains.add(personTrain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return personTrains;
	}

	public Person getPersonByUserId(PersonTrain personTrain,ResultSet resultset) {
		Person person = new Person();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from person where userId = "+personTrain.getUserId());
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				person.setUserId(resultSet.getInt(1));
				person.setUserName(resultSet.getString(2));
				person.setCityId(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);
		}
		return person;
	}

//	statement.execute("insert into person values(1,'sinboy',1)");
	public int addPerson(Person person,ResultSet resultset) {
		int userId = 0;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select max(userId) from person");
			resultSet = statement.executeQuery();
			resultSet.next();
			int maxUserId = resultSet.getInt(1);
			maxUserId++;
			userId = maxUserId;

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, resultSet);

			addPerson(person,userId,resultset);
		}
		return userId;
	}
	
	public void addPerson(Person person,int userId,ResultSet resultset) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			statement.execute("insert into person values("+userId+",'"+person.getUserName()+"',"+person.getCityId()+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, null);
		}
	}

	public void addInfo(Info info,ResultSet resultset) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			statement.execute("insert into info values("+info.getUserId()+",'"+info.getSex()+"',"+info.getAge()+",'"+info.getBorthday()+"'"+","+info.getHight()+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, null);
		}
		
	}

	public void addTrain(int trainId, int userId,ResultSet resultset) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			statement.execute("insert into personTrain values("+userId+","+trainId+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, null);
		}
	}
}
