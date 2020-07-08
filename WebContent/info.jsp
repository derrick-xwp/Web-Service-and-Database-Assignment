<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h3>ID：${person.userId }</h3>  
	<h3>Name：${person.userName }</h3>
        <h2>result of one to one relationship between table person and info</h2>
	<h3>Sex：${person.info.sex }</h3> 
	<h3>Hairlength：${person.info.age }</h3> 
	<h3>DOB:${person.info.borthday }</h3> 
	<h3>Height：${person.info.hight }</h3> 
        <h2>result of one to many relationship between table person and city</h2>
	<h3>City：${person.cityName }</h3> 
        <h2>result of many to many relationship between table person,person train and train</h2>
	<h3>Training involved：<c:forEach var="item" items="${person.trains }">|${item.trainName }|</c:forEach></h3> 
        <h2>The final query:</h2>
        <h3>select p.USERNAME,info.SEX,city.cityname, info.AGE, info.BORTHDAY, info.HIGHT,train.TRAINNAME,train.TRAINID from person p, city, info,train,persontrain where p.userid=${person.userId } and p.userid=info.USERID and p.CITYID=city.CITYID and ${person.userId }=persontrain.USERID and train.TRAINID = persontrain.TRAINID</h3> 

</div>
</body>
</html>