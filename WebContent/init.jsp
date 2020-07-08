<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="PersonServlet">
    <h3>This will show you all the person</h3>
    <h4>You could click the button directly,you could also modify the query, for the table person, it has column userid(1,2,3,4,5) and username(sinboy,tom,sii,white,king)</h4>
	<input type="text" name="sql" value="select * from person" /><br/>
	<input type="submit" value="see all the people"/>
</form>
<form action="CityServlet">
        <h3>This will show you all the cities</h3>
        <h4>You could click the button directly,you could also modify the query, for the table city, it has column cityid(1,2,3) and cityname(chicago,newyork,washington)</h4>
	<input type="text" name="sql" value="select * from city" /><br/>
	<input type="submit" value="see all the cities"/>
</form>
<form action="TrainServlet">
    <h3>This will show you all the trainings available</h3>
    <h4>You could click the button directly,you could also modify the query, for the table train, it has column trainid(1,2,3) and username(guitar,piano,harp)</h4>
	<input type="text" name="sql" value="select * from train" /><br/>
	<input type="submit" value="see all the trainings"/>
</form>
    
<h3>This will allow you to add new entries to the tables, either for one to one, one to many or many to many relationship</h3>
<h3>please click the href below</h3>  
<a href="addPerson.jsp">Add new entry</a>
</body>
</html>