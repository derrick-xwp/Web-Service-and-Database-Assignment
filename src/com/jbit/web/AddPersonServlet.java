package com.jbit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbit.biz.UserBiz;
import com.jbit.biz.impl.UserBizImpl;
import com.jbit.entity.Info;
import com.jbit.entity.Person;
import com.jbit.entity.sqlquery;
import java.sql.ResultSet;

@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBiz userBiz = new UserBizImpl(null);

		String userName = request.getParameter("userName");
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		Person person = new Person();
		person.setUserName(userName);
		person.setCityId(cityId);	
		int userId = userBiz.addPerson(person,null);
		String sex = request.getParameter("sex");
		String borthday = request.getParameter("borthday");
		double hight = Double.parseDouble(request.getParameter("hight"));
		int age = Integer.parseInt(request.getParameter("age"));
		Info info = new Info();
		info.setUserId(userId);
		info.setAge(age);
		info.setSex(sex);
		info.setBorthday(borthday);
		info.setHight(hight);
		System.out.println(info);
		userBiz.addInfo(info,null);
		
		String[] trainIds = request.getParameterValues("trainIds");
		if(trainIds!=null&&trainIds.length>0) {
			for (String trainIdStr : trainIds) {
				userBiz.addTrain(Integer.parseInt(trainIdStr),userId,null);
			}
		}
		
		response.sendRedirect("init.jsp");
	}

}
