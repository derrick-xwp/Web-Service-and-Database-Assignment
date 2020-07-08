package com.jbit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jbit.biz.UserBiz;
import com.jbit.biz.impl.UserBizImpl;
import com.jbit.entity.Person;
import com.jbit.entity.sqlquery;
import java.sql.ResultSet;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIdStr = request.getParameter("userId");
		int userId = Integer.parseInt(userIdStr);
		sqlquery exec= new sqlquery();
                ResultSet resultset=exec.execute("select p.USERNAME,info.SEX,city.cityname, info.AGE, info.BORTHDAY, info.HIGHT,train.TRAINNAME,train.TRAINID from person p, city, info,train,persontrain where p.userid="+userIdStr+" and p.userid=info.USERID and p.CITYID=city.CITYID and xxx.userId =persontrain.USERID and train.TRAINID = persontrain.TRAINID");
                
		UserBiz userBiz = new UserBizImpl(resultset);
		Person person = userBiz.getInfo(userId,resultset);
		HttpSession session = request.getSession();

		session.setAttribute("person", person);
		response.sendRedirect("info.jsp");
	}

}
