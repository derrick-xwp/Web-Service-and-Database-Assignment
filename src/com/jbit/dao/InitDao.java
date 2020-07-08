package com.jbit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDao extends BaseDao {

	public void init() {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("create table personTrain(userId int,trainId int)");
			statement.execute("create table person(userId int,userName varchar(50),cityId int)");
			statement.execute("create table city(cityId int,cityName varchar(50))");
			statement.execute("create table info(userId int,sex varchar(50),age int,borthday date,hight real)");
			statement.execute("create table train(trainId int,trainName varchar(50))");
			
			statement.execute("insert into person values(1,'sinboy',1)");
			statement.execute("insert into person values(2,'Tom',3)");
			statement.execute("insert into person values(3,'Sii',2)");
			statement.execute("insert into person values(4,'White',2)");
			statement.execute("insert into person values(5,'King',3)");

			statement.execute("insert into city values(1,'Chicago')");
			statement.execute("insert into city values(2,'New York')");
			statement.execute("insert into city values(3,'Washington')");
                        statement.execute("insert into city values(4,'')");
                        
			statement.execute("insert into info values(1,'girl',18,'2002-05-05',1.75)");
			statement.execute("insert into info values(2,'boy',19,'2001-04-04',1.5)");
			statement.execute("insert into info values(3,'girl',20,'2000-06-09',1.7)");
			statement.execute("insert into info values(4,'boy',18,'2002-04-01',1.6)");
			statement.execute("insert into info values(5,'boy',17,'2003-09-06',1.2)");
	        
			statement.execute("insert into train values(1,'Guitar')");
			statement.execute("insert into train values(2,'Piano')");
			statement.execute("insert into train values(3,'harp')");
			
			statement.execute("insert into personTrain values(1,1)");
			statement.execute("insert into personTrain values(1,2)");
			statement.execute("insert into personTrain values(2,2)");
			statement.execute("insert into personTrain values(2,3)");
			statement.execute("insert into personTrain values(3,1)");
			statement.execute("insert into personTrain values(3,3)");
			statement.execute("insert into personTrain values(4,1)");
			statement.execute("insert into personTrain values(4,2)");
			statement.execute("insert into personTrain values(4,3)");
			statement.execute("insert into personTrain values(5,2)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeResource(connection, statement, null);
		}
		
	
	}
}
