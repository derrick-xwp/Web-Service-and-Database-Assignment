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
        <h2>This will execute a one to many relationship query between table person and city</h2>
        <h2>You will see the person living in that city, please click on the href below to execute the following query:</h2>
        <h3>select p.USERNAME from person p,city where p.CITYID= xxx.cityId  and  p.CITYID = city.CITYID </h2>
	
<table>
	<tr>
		<th>ID</th>
		<th>City</th>
		<th>Operation</th>
	</tr>
	<c:forEach var="item" items="${citys }">
		<tr>
			<th>${item.cityId }</th>
			<th>${item.cityName }</th>
			<th><a href="PersonServlet?cityId=${item.cityId }">Check all the people from this city</a></th>
		</tr>
	</c:forEach>
                

</table>
</body>
</html>