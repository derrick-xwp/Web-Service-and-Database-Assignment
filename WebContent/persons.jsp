<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
        <h2>This will execute a one to many & one to one & many to many relationship query between table person, info, persontrain, train and city</h2>
        <h2>You will see all the information related to that person, please click on the href below to execute the following query:</h2>
        <h3>select p.USERNAME,info.SEX,city.cityname, info.AGE, info.BORTHDAY, info.HIGHT,train.TRAINNAME,train.TRAINID from person p, city, info,train,persontrain where p.userid=xxx.userId and p.userid=info.USERID and p.CITYID=city.CITYID and xxx.userId =persontrain.USERID and train.TRAINID = persontrain.TRAINID</h3>
	
<body>
        <table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Operation</th>

		</tr>
		<c:forEach var="item" items="${persons }">
			<tr>
				<th>${item.userId }</th>
				<th>${item.userName }</th>
				<th>
					<a href="GetInfo?userId=${item.userId }">See detailed information</a>
				</th>
                               
                                
                        </tr>
		</c:forEach>
	</table>
    
</body>
</html>