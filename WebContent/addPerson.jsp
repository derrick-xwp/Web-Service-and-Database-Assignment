<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>This will allow you to add new entry to the tables</h3>
    <h3>The function will check which type of entry it is, one to one/one to many/many to many</h3>
    <h3>The following queries may execute </h3>
    <h3>insert into info values(UserId+Sex+Age+Borthday,Hight)</h3>
    <h3>insert into person values(Id+UserName+CityId)</h3>
    <h3>insert into personTrain values(userId+trainId)</h3>
    <h3>and ...</h3>
<form action="AddPersonServlet" method="post">
	Name:<input name="userName" value="Harry" /><br/>
	Sex:<input name="sex" value="boy" /><br/>
	HairLength:<input name="age" value="8" /><br/>
	DOB:<input name="borthday" value="1998-09-07" /><br/>
	Height:<input name="hight" value="1.78" /><br/>
	City:
	<select name="cityId">
		<option value="1" selected="selected">Chicago</option>
		<option value="2">New York</option>
		<option value="3">Washington</option>
                <option value="4">null</option>
	</select>
	Training:
	<input type="checkbox" name="trainIds" value="1" checked="checked">Guitar
	<input type="checkbox" name="trainIds" value="2">Piano
	<input type="checkbox" name="trainIds" value="3">harp
	<input type="submit" value="submit">
</form>
</body>
</html>