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
        <h2>This will execute a one to many relationship query between table train,person and persontrain </h2>
        <h2>You will see the person under that train, please click on the href below to execute the following query:</h2>
        <h3>select person.USERNAME from train,person, persontrain where persontrain.TRAINID=train.TRAINID and person.USERID=persontrain.USERID and train.TRAINID=xxx </h2>
	
    
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Operation</th>
		</tr>
		<c:forEach var="item" items="${trains }">
			<tr>
				<th>${item.trainId }</th>
				<th>${item.trainName }</th>
				<th><a href="PersonServlet?trainId=${item.trainId }">check the people in this train</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>